package testService;

import org.junit.Test;

import service.PoiService;
import externalServices.BankService;

public class PoiExternalServiceTest {
	
	
	
	PoiService poiService= PoiService.getInstance();
	
	@Test
	public void getBanksFromExternalServiceTrue(){
		System.out.println(poiService.getBanksFromExternalService().size());
	}
	

}
