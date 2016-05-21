package controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;




import domain.Address;
import domain.Coordinate;
import poi.Bank;
import poi.Poi;
import service.PoiService;
import admin.Admin;


@Controller
public class AdminController {
	
	private Admin admin;
	
	public AdminController(){
		admin= new Admin();
	}
	
	@RequestMapping(value = ("/poi-add"), method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity addPoi(
			@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "type", required = true) String type) {

		
		Poi poi= new Bank(name,new Address("San Miguel"),new Coordinate(34.654,32.564));
		
		admin.addPoi(poi);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value = ("/poi-remove"), method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity removePoi(
			@RequestParam(value = "name", required = true) String name) {
		
		boolean state= admin.removePoi(name);
		return new ResponseEntity(state,HttpStatus.OK);
	}
	

	

	
	
}
