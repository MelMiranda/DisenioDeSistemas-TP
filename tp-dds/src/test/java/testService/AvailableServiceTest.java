package testService;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.apache.http.client.ClientProtocolException;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import poi.Bank;
import poi.BusStation;
import poi.CGP;
import poi.ComercialShop;
import poi.Library;
import poi.Newspapers;
import service.AvailabilityService;
import service.PoiService;
import domain.Address;
import domain.CGPService;
import domain.Coordinate;
import domain.RangeOfAtention;
import domain.Schedule;

@SuppressWarnings("deprecation")
public class AvailableServiceTest {
	
	private final static Logger LOGGER= LoggerFactory.getLogger(AvailableServiceTest.class);
	private PoiService poiService;
	private Bank bank;
	private Coordinate cordinate1;
	private Coordinate cordinate2;
	private CGPService rentas;
	private AvailabilityService availabilityService;
	private ComercialShop newsPapersShop;
	private ComercialShop schoolLibraryShop;
	private Newspapers newspapers;
	private Library schoolLibrary;
	private CGP cgp2;
	private CGPService cgpService;
	private RangeOfAtention range1;
	private ArrayList<CGPService> cgpServices;
	private List<Integer> days1;
	private List<Integer> rentasDaysAttention;
	private List<Schedule> schedules1;
	private List<Schedule> schedulesRentas;
	private Date date;

	@Before
	public void initialize() {
		date= new Date();

		double lat1 = -34.8128118;
		double lon1 = -58.4516456;
		double lat2 = -34.81725;
		double lon2 = -58.4476116;

		cordinate1 = new Coordinate(lat1,lon1);
		cordinate2 = new Coordinate(lat2, lon2);
		poiService = new PoiService(cordinate1);

		bank = new Bank("Bank", new Address(), cordinate2);	
		
		schedules1 = new ArrayList<Schedule>();
		schedulesRentas= new ArrayList<Schedule>();
		rentasDaysAttention= new ArrayList<Integer>();
		days1=new ArrayList<Integer>();

		//schedules1.add(new Schedule("05:23", "06:37"));
		schedules1.add(new Schedule("03:00", "19:00"));
		availabilityService= AvailabilityService.getInstance();
		schoolLibrary= Library.getInstance(500);
		
		newsPapersShop= new ComercialShop("Diarios Sistemas", new Address(), cordinate1, newspapers);
		schoolLibraryShop= new ComercialShop("Carrousel",new Address(),cordinate2,schoolLibrary);
		range1=new RangeOfAtention(schedules1, days1);
		
		schedulesRentas.add(new Schedule("10:30","20:00"));
		
		rentasDaysAttention.add(1);
		rentasDaysAttention.add(2);
		rentasDaysAttention.add(3);
		rentasDaysAttention.add(4);
		rentasDaysAttention.add(5);
		
		rentas= new CGPService("rentas",new RangeOfAtention(schedulesRentas,rentasDaysAttention));
		
		cgpService=new CGPService("cualquiera", range1);
		
		availabilityService= AvailabilityService.getInstance();
		cgpServices=new ArrayList<CGPService>();
		cgpServices.add(rentas);
		cgpServices.add(cgpService);
			
		cgp2=new CGP("mauri", new Address(),  cordinate1, 300.0, cgpServices);
	}
	

	@Test
	public void testBankIsAvaiableFalse() throws ClientProtocolException, IOException {
		Date date=new Date();
		LOGGER.info(date.toString());
		Assert.assertFalse(poiService.isAvailable(bank));
	}
	
	@Test
	public void testRentasIsAvaiableTrue(){
		LOGGER.info(date.toString());
		Assert.assertFalse(cgp2.isAvailable("rentas"));
		
	}
	
	
	@Test
	public void testAnyIsAvaiable(){
		LOGGER.info(date.toString());
		Assert.assertFalse(cgp2.isAvailable());
	}
	
	@Test
	public void testSchoolLibrary(){
		Assert.assertTrue(schoolLibrary.isAvailable(availabilityService));
	}
	

}
