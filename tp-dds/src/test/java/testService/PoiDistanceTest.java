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
import poi.ComercialShop;
import poi.Newspapers;
import poi.Library;
import service.AvailabilityService;
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
	private ComercialShop newsPapersShop;
	private Newspapers newspapers;
	

	@Before
	public void initialize() {
		double lat1 = -34.8128118;
		double lon1 = -58.4516456;
		double lat2 = -34.81725;
		double lon2 = -58.4476116;
		cordinate1 = new Coordinate(lat1,lon1);
		cordinate2 = new Coordinate(lat2, lon2);
		cordinate3 = new Coordinate(0, 0);
		poiService = new PoiService(cordinate1);
		newspapers= Newspapers.getInstance(700);
		newsPapersShop= new ComercialShop("Diarios Sistemas", new Address(), cordinate1, newspapers);
		cgp = new CGP("CGP", new Address(), cordinate2, 700.0, new ArrayList<CGPService>());
		busStation = new BusStation("Parada de Bus", new Address(), cordinate2);
		bank = new Bank("Bank", new Address(), cordinate2);
		bank2 = new Bank("Bank", new Address(),  cordinate3);
		bank3=new Bank("Bank", new Address(),new Coordinate(-34.813208,-58.451356));
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
		Assert.assertTrue(poiService.isNearby(newsPapersShop));
	}
	

	@Test
	public void testBankisNerby() throws ClientProtocolException, IOException {
		Assert.assertFalse(poiService.isNearby(bank));
	}

	
	 @Test(expected = UnknownHostException.class)
	 public void testNoConnection() throws ClientProtocolException, IOException {
	 Assert.assertFalse(poiService.isNearby(bank)); }
	
	
}
