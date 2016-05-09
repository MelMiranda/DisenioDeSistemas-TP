package testService;

import static org.junit.Assert.*;

import org.junit.Test;

import domainPOI.Address;
import domainPOI.BusStation;
import domainPOI.Coordinate;
import http.HttpRequest;
import service.PoiService;

public class serviceTest {

	@Test
	public void test() {
		//	String ur2l="https://maps.googleapis.com/maps/api/distancematrix/json?origins=-34.8116466,-58.4514427&destinations=-34.8148093,-58.4531344&key=AIzaSyADv7wpbNqFOLDQjNXGXEcM1oAhCDEJHzw";

		
		PoiService poiService=new PoiService(new Coordinate(-34.8116466, -58.4514427),new HttpRequest());
		BusStation busPoi=new Poi("nombre",new Address(),)
		
		fail("Not yet implemented");
	}

}
