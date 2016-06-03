package testService;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import poi.Bank;
import service.PoiService;

public class PoiExternalServiceTest {
	
	PoiService poiService= PoiService.getInstance();
	
	@SuppressWarnings("deprecation")
	@Test
	public void getBanksFromExternalServiceTrue(){
		List<Bank> banks= poiService.getBanksFromExternalService("banco","servicio");
		Assert.assertTrue(banks!=null);
	}

}
