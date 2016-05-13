package poi;

import java.io.IOException;
import java.util.Date;

import org.apache.http.client.ClientProtocolException;

import domain.Address;
import domain.Coordinate;

public class BusStation extends Poi {

	public BusStation(String name, Address address,  Coordinate coordinate) {
		this.name = name;
		this.address = address;
		this.coordinate = coordinate;
	}

	@Override
	public boolean isNearby(Coordinate coordinate) throws ClientProtocolException, IOException {
		double distance = this.getGoogleService().getDistance(coordinate, this.getCoordinate());
		return distance < 100;
	}

	@Override
	public String getType() {
		return null;
	}

	@Override
	public boolean isAvailable(Date date) {
		//boolean available =this.getAvailabilityService().isAvailability(date, this.getRangeOfAtention());
		return true;
	}

}
