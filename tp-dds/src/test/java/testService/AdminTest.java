package testService;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

import domain.Address;
import domain.Coordinate;
import poi.BusStation;
import poi.Poi;
import service.PoiService;
import admin.Admin;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdminTest {

	private Admin admin;
	private PoiService poiService;
	private static final Logger LOGGER= LoggerFactory.getLogger(AdminTest.class);

	Address address;
	Coordinate coordinate;
	String poiName;
	String busNumber;
	BusStation busStation;

	@Before
	public void setUp() {
		
		admin = new Admin();
		poiService = admin.getPoiService();
		address = new Address("San Justo 77");
		coordinate = new Coordinate(-34.76, 56.76);
		poiName = "Parada 144, San Justo";
		busNumber = "144";
		busStation = new BusStation(poiName, address, coordinate, busNumber);

	}

	@Test
	public void addPoiIntoPoiService() {
		
		LOGGER.info("Metodo addPoi");
		LOGGER.info("" + poiService.getAllPois().size());

		Assert.assertTrue(poiService.getAllPois().isEmpty());

		admin.addPoi(busStation);

		LOGGER.info("" + poiService.getAllPois().size());
		
		Assert.assertTrue(poiService.getAllPois().size() == 1);

	}
	

	@Test
	public void cremovePoiIntoPoiService() {
		LOGGER.info("Metodo removePoi");

		Assert.assertTrue(poiService.getAllPois().size() == 1);

		admin.removePoi(poiName);

		Assert.assertTrue(poiService.getAllPois().isEmpty());

	}

}
