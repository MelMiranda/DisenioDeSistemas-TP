package poi;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import domain.Address;
import domain.Coordinate;
import domain.RangeOfAtention;

public class BusStation extends Poi {
	
	

	public BusStation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BusStation(String name, Address address, String mainStreet, Coordinate coordinate,
			RangeOfAtention rangeOfAtention) {
		super(name, address, mainStreet, coordinate, rangeOfAtention);
	}

	public boolean isEnable() {
		return true;
	}

	@Override
	public boolean isNearBy(Coordinate coordinate) throws ClientProtocolException, IOException {
		double distance = this.getGoogleService().getDistance(coordinate, this.getCoordinate());
		return distance < 100;
	}

	@Override
	public String getType() {
		return null;
	}

}
