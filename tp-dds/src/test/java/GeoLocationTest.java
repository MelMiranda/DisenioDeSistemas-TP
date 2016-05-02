import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import service.GeoLocation;
import domainPOI.Coordinate;


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
		System.out.println(geoLocation.distanceFrom(coordinate1,coordinate2));
		assertTrue(geoLocation.distanceFrom(coordinate1,coordinate2)<500);
		
		DateTime date=new DateTime();
		
		System.out.println(date.getDayOfWeek());
	}
	

	

	


}
