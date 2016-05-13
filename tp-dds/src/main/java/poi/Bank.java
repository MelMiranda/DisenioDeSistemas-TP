package poi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import domain.Address;
import domain.Coordinate;
import domain.RangeOfAtention;

public class Bank extends Poi {
	private RangeOfAtention rangeOfAtention;

	public Bank() {
		super();
	}

	public Bank(String name, Address address, String mainStreet, Coordinate coordinate){
		super(name, address, mainStreet, coordinate);
		this.rangeOfAtention=new RangeOfAtention();
	}

	
	
	public RangeOfAtention getRangeOfAtention() {
		return rangeOfAtention;
	}

	public void setRangeOfAtention(RangeOfAtention rangeOfAtention) {
		this.rangeOfAtention = rangeOfAtention;
	}

	public boolean isEnable() {
		return true; // TO DO
	}

	public String getType() {

		return "Bank";

	}

	public boolean isNearBy(Coordinate coordinate) throws ClientProtocolException, IOException {
		double distance = this.getGoogleService().getDistance(coordinate, this.getCoordinate());
		return distance < 100;
	}

	@Override
	public boolean isAvailable(Date date) {
		return this.getAvailabilityService().isAvailability(date, this.getRangeOfAtention());
	}
	
	

}
