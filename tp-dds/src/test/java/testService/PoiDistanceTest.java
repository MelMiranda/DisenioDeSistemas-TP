package testService;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.Address;
import domain.CGPService;
import domain.Coordinate;
import domain.RangeOfAtention;
import domain.Schedule;
import junit.framework.Assert;
import poi.Bank;
import poi.BusStation;
import poi.CGP;
import poi.CategoryShop;
import poi.ComercialShop;
import poi.Newspapers;
import service.PoiService;

@SuppressWarnings("deprecation")
public class PoiDistanceTest {

	
	private final static Logger LOGGER= LoggerFactory.getLogger(PoiDistanceTest.class);
	private PoiService poiService;
	private CGP cgp;
	private BusStation busStation;
	private Bank bank;
	private Bank bank2;
	private Bank bank3;
	private Coordinate cordinate1;
	private Coordinate cordinate2;
	private Coordinate cordinate3;
	private Coordinate cordinateNewspaper;
	
	private ComercialShop comercialShop;
	private Newspapers newspapers;

	// ----->2
	private CGP cgp2;
	private CGPService cgpService;
	private RangeOfAtention range1;


	private ArrayList<CGPService> cgpServices;
	private List<Integer> days1;

	private List<Schedule> schedules1;

	@Before
	public void initialize() {

		double lat1 = -34.8128118;
		double lon1 = -58.4516456;
		double lat2 = -34.81725;
		double lon2 = -58.4476116;

		cordinate1 = new Coordinate(lat1,lon1);
		cordinate2 = new Coordinate(lat2, lon2);
		cordinate3 = new Coordinate(0, 0);
		cordinateNewspaper=cordinate2;
		poiService = new PoiService(cordinate1);
		newspapers= new Newspapers(700);
		
		comercialShop= new ComercialShop("Diarios Sistemas", new Address(), "mainStreet", cordinateNewspaper, newspapers);

		cgp = new CGP("CGP", new Address(), "por ahi", cordinate2, 700.0, new ArrayList<CGPService>());
		busStation = new BusStation("Parada de Bus", new Address(), "por aca", cordinate2);
		bank = new Bank("Bank", new Address(), "medrano", cordinate2);
		bank2 = new Bank("Bank", new Address(), "medrano", cordinate3);
		bank3=new Bank("Bank", new Address(),"no se",new Coordinate(-34.813208,-58.451356));
		

		// ------------->2		
		
		schedules1 = new ArrayList<Schedule>();
		days1=new ArrayList<Integer>();

		//schedules1.add(new Schedule("05:23", "06:37"));
		schedules1.add(new Schedule("03:00", "08:00"));

		days1.add(1);
		days1.add(2);
		days1.add(3);
		days1.add(4);
		days1.add(5);
		days1.add(6);
		days1.add(7);

		
		range1=new RangeOfAtention(schedules1, days1);
		
		cgpService=new CGPService("cualquiera", range1);
		cgpServices=new ArrayList<CGPService>();
		cgpServices.add(cgpService);
			
		
		cgp2=new CGP("mauri", new Address(), "9 de julio", cordinate1, 300.0, cgpServices);
	}

	@Test
	public void GoogleServicetest() throws ClientProtocolException, IOException {
		Assert.assertEquals(632.0, cgp.getGoogleService().getDistance(cordinate1, cordinate2));

	}

	@Test
	public void test2() throws ClientProtocolException, IOException {
		Assert.assertTrue(poiService.isNearby(cgp));
	}

	@Test(expected = NullPointerException.class)
	public void testBadCoordinates() throws ClientProtocolException, IOException {
		poiService.isNearby(bank2);
	}

	@Test
	public void testBusStationNearByFalse() throws ClientProtocolException, IOException {
		Assert.assertFalse(poiService.isNearby(busStation));
	}
	
	@Test
	public void testBankNearByTrue() throws ClientProtocolException, IOException{
		Assert.assertTrue(poiService.isNearby(bank3));
	}
	
	
	
	@Test
	public void testNewspaperNearbyFalse() throws ClientProtocolException, IOException{
		Assert.assertTrue(poiService.isNearby(comercialShop));
	}
	

	@Test
	public void testBank() throws ClientProtocolException, IOException {
		Assert.assertFalse(poiService.isNearby(bank));

	}

	
	 @Test(expected = UnknownHostException.class)
	 public void testNoConnection() throws ClientProtocolException, IOException {
	 Assert.assertFalse(poiService.isNearby(bank)); }
	 

	@Test
	public void testBankisAvaiable() throws ClientProtocolException, IOException {
		Date date=new Date();
	//	poiService.isavailable(bank, date);
		LOGGER.info("Result of test:" + poiService.isavailable(bank, date));
		Assert.assertFalse(poiService.isavailable(bank, date));
	}
}
