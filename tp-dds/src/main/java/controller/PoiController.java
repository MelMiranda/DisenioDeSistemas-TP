package controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import service.PoiService;

@Controller
public class PoiController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(PoiController.class);
	
	private PoiService poiService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = ("/poi-bank"), method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Integer> generateBestTrip(
			@RequestParam(value = "bank", required = true) String bank,
			@RequestParam(value = "service", required = true) String service) {
		poiService=PoiService.getInstance();
		LOGGER.info("--------------------------------------------------------");
		LOGGER.info("REQUEST");
		LOGGER.info("--------------------------------------------------------");
		
			
			int banksnumber= poiService.getBanksFromExternalService(bank, service).size();
			
			LOGGER.info("--------------------------------------------------------");
			LOGGER.info("RESPONSE");
			LOGGER.info("--------------------------------------------------------");
			return new ResponseEntity<Integer>(banksnumber,HttpStatus.OK);
			
	}
	
	
	
	
	
	
	
	
	

}
