package controller;

import java.util.ArrayList;
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
import poi.BusStation;
import poi.CGP;
import poi.CGPService;
import poi.Poi;
import service.PoiService;
import admin.Admin;

@Controller
public class AdminController {

	private Admin admin;

	public AdminController() {
		admin = new Admin();
	}


	@RequestMapping(value = ("/poi-remove"), method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity removePoi(
			@RequestParam(value = "name", required = true) String name) {

		boolean state = admin.removePoi(name);
		return new ResponseEntity(state, HttpStatus.OK);
	}

	@RequestMapping(value = ("/poi-modify"), method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity modifyPoi(
			@RequestParam(value = "name", required = true) String name) {
		Poi poi = null; // TODO Agregar muchos parametros y filtrar tipo por
						// type
		boolean state = admin.modifyPoi(poi, name);
		return new ResponseEntity(state, HttpStatus.OK);
	}

	
	
	@RequestMapping(value = ("/poi-addBank"), method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity addPoiBank(
			@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "type", required = true) String type,
			@RequestParam(value = "mainStreet", required = true) String mainStreet,
			@RequestParam(value = "lat", required = true) double lat,
			@RequestParam(value = "lon", required = true) double lon){

		Poi poi = new Bank(name,new Address(mainStreet), new Coordinate(lat,lon));

		admin.addPoi(poi);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	
	@RequestMapping(value = ("/poi-addBusStation"), method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity addPoiBusStation(
			@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "type", required = true) String type,
			@RequestParam(value = "mainStreet", required = true) String mainStreet,
			@RequestParam(value = "lat", required = true) double lat,
			@RequestParam(value = "lon", required = true) double lon,
			@RequestParam(value = "busNumber", required = true) String busNumber){
		// TODO Agregar muchos parametros y filtrar tipo por type

		Poi poi=new BusStation(name,new Address(mainStreet), new Coordinate(lat,lon),busNumber);
		admin.addPoi(poi);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	
	@RequestMapping(value = ("/poi-addCGP"), method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity addPoiCGP(
			@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "type", required = true) String type,
			@RequestParam(value = "mainStreet", required = true) String mainStreet,
			@RequestParam(value = "lat", required = true) double lat,
			@RequestParam(value = "lon", required = true) double lon,
			@RequestParam(value = "communeRadius", required = true) double communeRadius){
		// TODO Agregar muchos parametros y filtrar tipo por type

		Poi poi= new CGP(name,new Address(mainStreet), new Coordinate(lat,lon),communeRadius,new ArrayList<CGPService>());
		admin.addPoi(poi);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	
	
	
	
}
