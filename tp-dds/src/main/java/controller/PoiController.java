package controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import poi.Poi;
import service.PoiService;

@Controller
public class PoiController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(PoiController.class);

	private PoiService poiService;

/*	@SuppressWarnings("unchecked")
	@RequestMapping(value = ("/poi-bank"), method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Poi>> showPois(
			@RequestParam(value = "bank", required = true) String bank,
			@RequestParam(value = "service", required = true) String service) {
		poiService = PoiService.getInstance();
		LOGGER.info("--------------------------------------------------------");
		LOGGER.info("REQUEST");
		LOGGER.info("--------------------------------------------------------");

		List<Poi> pois = poiService.getAllPois();

		LOGGER.info("--------------------------------------------------------");
		LOGGER.info("RESPONSE");
		LOGGER.info("--------------------------------------------------------");
		return new ResponseEntity<List<Poi>>(pois, HttpStatus.OK);

	}*/
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = ("/poi-size"), method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Integer> showPois(
			@RequestParam(value = "bank", required = true) String bank,
			@RequestParam(value = "service", required = true) String service) {
		poiService = PoiService.getInstance();
		LOGGER.info("--------------------------------------------------------");
		LOGGER.info("REQUEST");
		LOGGER.info("--------------------------------------------------------");

		int size = poiService.getAllPois().size();

		LOGGER.info("--------------------------------------------------------");
		LOGGER.info("RESPONSE");
		LOGGER.info("--------------------------------------------------------");
		return new ResponseEntity<Integer>(size, HttpStatus.OK);

	}

}
