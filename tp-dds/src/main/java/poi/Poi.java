package poi;

import java.io.IOException;
import java.util.Date;

import org.apache.http.client.ClientProtocolException;

import ExternService.GoogleService.GoogleDistanceService;
import domain.Address;
import domain.Coordinate;
import service.AvailabilityService;

public abstract class Poi implements PoiInterface {

	private String name;
	private Address address;
	private String mainStreet;
	private Coordinate coordinate;
	private GoogleDistanceService googleService = GoogleDistanceService.getInstance();
	private AvailabilityService availabilityService = AvailabilityService.getInstance();

	public Poi(String name, Address address, String mainStreet, Coordinate coordinate) {
		super();
		this.name = name;
		this.address = address;
		this.mainStreet = mainStreet;
		this.coordinate = coordinate;
		}

	public GoogleDistanceService getGoogleService() {
		return googleService;
	}

	public void setGoogleService(GoogleDistanceService googleService) {
		this.googleService = googleService;
	}

	public AvailabilityService getAvailabilityService() {
		return availabilityService;
	}

	public void setAvailabilityService(AvailabilityService availabilityService) {
		this.availabilityService = availabilityService;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Poi() {
		super();
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getMainStreet() {
		return mainStreet;
	}

	public void setMainStreet(String mainStreet) {
		this.mainStreet = mainStreet;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate cordinate) {
		this.coordinate = cordinate;
	}

	public boolean isNearby(Coordinate cordinate) throws ClientProtocolException, IOException {
		return this.googleService.getDistance(this.coordinate, cordinate) < 500;
	}

	public boolean isAvailable(Date date) {
		return false;
	}

}
