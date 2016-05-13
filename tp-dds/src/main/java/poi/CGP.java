package poi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.http.client.ClientProtocolException;

import domain.Address;
import domain.CGPService;
import domain.Coordinate;

public class CGP extends Poi {

	private double communeRadius;
	private ArrayList<CGPService> services;

	public CGP(String name, Address address, String mainStreet, Coordinate coordinate, double communeRadius,
			ArrayList<CGPService> services) {
		super(name, address, mainStreet, coordinate);
		this.communeRadius = communeRadius;
		this.services = services;
	}

	public double getCommuneRadius() {
		return communeRadius;
	}

	public void setCommuneRadius(double communeRadius) {
		this.communeRadius = communeRadius;
	}

	public ArrayList<CGPService> getServices() {
		return services;
	}

	public void setServices(ArrayList<CGPService> services) {
		this.services = services;
	}

	@Override
	public boolean isNearby(Coordinate coordinate) throws ClientProtocolException, IOException {
		double distance = this.getGoogleService().getDistance(coordinate, this.getCoordinate());
		return distance < communeRadius;
	}

	@Override
	public String getType() {
		return null;
	}

	@Override
	public boolean isAvailable(Date date) {
		for (CGPService cgpService : services) {
			if(cgpService.isAvailable(date, this.getAvailabilityService())){
				return true;
			}
	}				
		return false ;
	}

	public boolean isAvailable(Date date, String serviceName) {
		int i = 0;

		if (!(this.getServices().isEmpty())) {
			while (i <= this.getServices().size()) {
				if (this.getServices().get(i).getServiceName().equals(serviceName)) {
					return this.getServices().get(i).isAvailable(date, this.getAvailabilityService());
				}
			}
		}
		return false;
	}

}
