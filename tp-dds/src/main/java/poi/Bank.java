package poi;

import java.io.IOException;
import java.util.Date;

import org.apache.http.client.ClientProtocolException;

import domain.Address;
import domain.Coordinate;
import domain.RangeOfAtention;

public class Bank extends Poi {

	public Bank() {
		super();
	}

	public Bank(String name, Address address, String mainStreet, Coordinate coordinate){
		super(name, address, mainStreet, coordinate);
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
	public boolean isAvailable(Date dasdfte) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
