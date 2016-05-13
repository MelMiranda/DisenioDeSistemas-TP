package poi;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.http.client.ClientProtocolException;

import domain.Address;
import domain.CGPService;
import domain.Coordinate;

public class CGP extends Poi{
	
	private double communeRadius;
	private ArrayList<CGPService> services;
	
	
	
	public CGP(String name, Address address, String mainStreet, Coordinate coordinate,
			double communeRadius, ArrayList<CGPService> services) {
		super(name, address, mainStreet, coordinate);
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



	@Override
	public boolean isAvailable(Date dasdfte) {
		// TODO Auto-generated method stub
		return false;
	}
	



}
