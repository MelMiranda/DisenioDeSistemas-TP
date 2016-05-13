package poi;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import domain.Address;
import domain.Coordinate;
import domain.RangeOfAtention;

public class Bank extends Poi {

	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bank(String name, Address address, String mainStreet, Coordinate coordinate,
			RangeOfAtention rangeOfAtention) {
		super(name, address, mainStreet, coordinate, rangeOfAtention);
		// TODO Auto-generated constructor stub
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

}
