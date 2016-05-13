package testService;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import org.apache.http.client.ClientProtocolException;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.Address;
import domain.CGPService;
import domain.Coordinate;
import domain.RangeOfAtention;
import http.HttpRequest;
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

	@Before
	public void initialize() {
		
		double lat1=-34.8128118;
		double lon1=-58.4516456;
		double lat2=-34.81725;
		double lon2=-58.4476116;
		
		poiService = new PoiService(new Coordinate(lon1,lat1 ), new HttpRequest());
		cgp=new CGP("CGP", new Address(), "por ahi", new Coordinate(lon2, lat2), new RangeOfAtention("08:30", "08:30", new ArrayList<String>()), 200.0, new ArrayList<CGPService>());
		busStation=new BusStation("Parada de Bus", new Address() , "por aca", new Coordinate(lon2, lat2), new RangeOfAtention("08:30", "08:30", new ArrayList<String>()));
		bank=new Bank("Bank", new Address(), "medrano", new Coordinate(lon2, lat2), new RangeOfAtention("08:30", "08:30", new ArrayList<String>()));
	
	}

	@Test
	public void test() throws ClientProtocolException, IOException {
		//	String ur2l="https://maps.googleapis.com/maps/api/distancematrix/json?origins=-34.8116466,-58.4514427&destinations=-34.8148093,-58.4531344&key=AIzaSyADv7wpbNqFOLDQjNXGXEcM1oAhCDEJHzw";
		if(poiService.isNearby(cgp)){
		LOGGER.info("siii perro");
		}
		System.out.println(poiService.isNearby(cgp));
	}

}
