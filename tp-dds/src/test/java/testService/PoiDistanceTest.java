package testService;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import org.apache.http.client.ClientProtocolException;
import org.junit.Before;
import org.junit.Test;

import domain.Address;
import domain.CGPService;
import domain.Coordinate;
import junit.framework.Assert;
import poi.Bank;
import poi.BusStation;
import poi.CGP;
import service.PoiService;

@SuppressWarnings("deprecation")
public class PoiDistanceTest {

	private PoiService poiService;
	private CGP cgp;
	private BusStation busStation;
	private Bank bank;
	private Bank bank2;
	private Coordinate cordinate1;
	private Coordinate cordinate2;
	private Coordinate cordinate3;

	@Before
	public void initialize() {

		double lat1 = -34.8128118;
		double lon1 = -58.4516456;
		double lat2 = -34.81725;
		double lon2 = -58.4476116;

		cordinate1 = new Coordinate(lon1, lat1);
		cordinate2 = new Coordinate(lon2, lat2);
		cordinate3 = new Coordinate(0, 0);
		poiService = new PoiService(cordinate1);

		cgp = new CGP("CGP", new Address(), "por ahi", cordinate2, 700.0, new ArrayList<CGPService>());
		busStation = new BusStation("Parada de Bus", new Address(), "por aca", cordinate2);
		bank = new Bank("Bank", new Address(), "medrano", cordinate2);
		bank2 = new Bank("Bank", new Address(), "medrano", cordinate3);

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
	public void testBusStation() throws ClientProtocolException, IOException {
		Assert.assertFalse(poiService.isNearby(busStation));
	}

	@Test
	public void testBank() throws ClientProtocolException, IOException {
		Assert.assertFalse(poiService.isNearby(bank));
	}

/*	@Test(expected = UnknownHostException.class)
	public void testNoConnection() throws ClientProtocolException, IOException {
		Assert.assertFalse(poiService.isNearby(bank));
	}*/

}
