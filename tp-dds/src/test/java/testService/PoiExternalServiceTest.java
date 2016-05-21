package testService;
import junit.framework.Assert;

import org.junit.Test;

import service.PoiService;

public class PoiExternalServiceTest {
	
	PoiService poiService= PoiService.getInstance();
	
	@SuppressWarnings("deprecation")
	@Test
	public void getBanksFromExternalServiceTrue(){
		Assert.assertTrue(poiService.getBanksFromExternalService("banco","servicio")!=null);
	}

}
