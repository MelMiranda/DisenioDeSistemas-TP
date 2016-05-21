package poi;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import domain.Address;
import domain.Coordinate;

public class BusStation extends Poi {
	
	private int numberBusStation ;


	

	public BusStation(String name, Address address, Coordinate coordinate, String numberBusStation) {
		super(name, address, coordinate);
		this.getData().add(name);
		this.getData().add( numberBusStation);
		this.getData().add(address.getMainStreet());
		this.getData().add("bus");
		}

	public int getNumberBusStation() {
		return numberBusStation;
	}

	public void setNumberBusStation(int numberBusStation) {
		this.numberBusStation = numberBusStation;
	}

	@Override
	public boolean isNearby(Coordinate coordinate) throws ClientProtocolException, IOException {
		double distance = this.getGoogleService().getDistance(coordinate, this.getCoordinate());
		return distance < 100;
	}

	@Override
	public String getType() {
		return "BusStation";
	}

	@Override
	public boolean isAvailable() {
		return true;
	}

}
