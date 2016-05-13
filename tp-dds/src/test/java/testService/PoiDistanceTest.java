package testService;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import org.apache.http.client.ClientProtocolException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ExternService.GoogleService.GoogleDistanceService;

import static org.mockito.Mockito.*;
import domain.Address;
import domain.CGPService;
import domain.Coordinate;
import domain.RangeOfAtention;
import junit.framework.Assert;
import poi.Bank;
import poi.BusStation;
import poi.CGP;
import service.PoiService;

public class PoiDistanceTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(PoiDistanceTest.class);
	private PoiService poiService;
	private CGP cgp;
	private BusStation busStation;
	private Bank bank;
	private Bank bank2;
	private Coordinate cordinate1;
	private Coordinate cordinate2;
	private Coordinate cordinate3;
	private GoogleDistanceService googleDistanceService;

	@Before
	public void initialize() {

		double lat1 = -34.8128118;
		double lon1 = -58.4516456;
		double lat2 = -34.81725;
		double lon2 = -58.4476116;

		cordinate1 = new Coordinate(lon1, lat1);
		cordinate2 = new Coordinate(lon2, lat2);
		cordinate3=new Coordinate(0, 0);
		googleDistanceService=mock(GoogleDistanceService.class);
		poiService = new PoiService(cordinate1);
		
		
		
		cgp = new CGP("CGP", new Address(), "por ahi", cordinate2,
				new RangeOfAtention("08:30", "08:30", new ArrayList<String>()), 700.0, new ArrayList<CGPService>());
		busStation = new BusStation("Parada de Bus", new Address(), "por aca", cordinate2,
				new RangeOfAtention("08:30", "08:30", new ArrayList<String>()));
		bank = new Bank("Bank", new Address(), "medrano", cordinate2,
				new RangeOfAtention("08:30", "08:30", new ArrayList<String>()));
		bank2 = new Bank("Bank", new Address(), "medrano", cordinate3,
				new RangeOfAtention("08:30", "08:30", new ArrayList<String>()));
		

	}

	@Test
	public void GoogleServicetest() throws ClientProtocolException, IOException {
		// String
		// ur2l="https://maps.googleapis.com/maps/api/distancematrix/json?origins=-34.8116466,-58.4514427&destinations=-34.8148093,-58.4531344&key=AIzaSyADv7wpbNqFOLDQjNXGXEcM1oAhCDEJHzw";
		Assert.assertEquals(632.0, cgp.getGoogleService().getDistance(cordinate1, cordinate2));

	}

	@Test
	public void test2() throws ClientProtocolException, IOException {
		// String
		// ur2l="https://maps.googleapis.com/maps/api/distancematrix/json?origins=-34.8116466,-58.4514427&destinations=-34.8148093,-58.4531344&key=AIzaSyADv7wpbNqFOLDQjNXGXEcM1oAhCDEJHzw";
		Assert.assertTrue(poiService.isNearby(cgp));
	}
	@Test(expected = NullPointerException.class)
	public void testBadCoordinates() throws ClientProtocolException, IOException{
		poiService.isNearby(bank2);		
	}
	
	@Test
	public void testBusStation() throws ClientProtocolException, IOException{
		Assert.assertFalse(poiService.isNearby(busStation));		
	}
	@Test
	public void testBank() throws ClientProtocolException, IOException{
		Assert.assertFalse(poiService.isNearby(bank));
	}
	
	@Test (expected=UnknownHostException.class)
	public void testNoConnection() throws ClientProtocolException, IOException{
		Assert.assertFalse(poiService.isNearby(bank));
	}
	
	
	
	
}
