import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domainPOI.Coordinate;
import domainPOI.GeoLocation;

public class GeoLocationTest {

	private GeoLocation geoLocation;
	private Coordinate coordinate1;
	private Coordinate coordinate2;
	
	@Before
	public void setUp(){
		geoLocation= new GeoLocation();
		coordinate1 = new Coordinate(-34.544107866986884,-58.706122264266014);
		coordinate2=  new Coordinate(-34.546907013784164,-58.70237052440643);
		
	}
	
	
	@Test
	public void distanceTest(){
		assertTrue(geoLocation.distanceFrom(coordinate1,coordinate2)<500);
	}


	


}
