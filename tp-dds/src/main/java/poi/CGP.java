package poi;


import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.client.ClientProtocolException;

import domain.Address;
import domain.CGPService;
import domain.Coordinate;
import domain.RangeOfAtention;


public class CGP extends Poi{
	
	private double communeRadius;
	private ArrayList<CGPService> services;
	
	
	
	public CGP(String name, Address address, String mainStreet, Coordinate coordinate, RangeOfAtention rangeOfAtention,
			double communeRadius, ArrayList<CGPService> services) {
		super(name, address, mainStreet, coordinate, rangeOfAtention);
		this.communeRadius = communeRadius;
		this.services = services;
	}



	@Override
	public boolean isNearBy(Coordinate coordinate) throws ClientProtocolException, IOException {
		double distance= this.getGoogleService().getDistance(coordinate, this.getCoordinate());
		return distance<communeRadius;
	}



	@Override
	public String getType() {
		return null;
	}
	



}
