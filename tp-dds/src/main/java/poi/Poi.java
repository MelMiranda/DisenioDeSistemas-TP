package poi;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.client.ClientProtocolException;

import ExternService.GoogleService.GoogleDistanceService;
import domain.Address;
import domain.Coordinate;
import domain.RangeOfAtention;

public abstract class Poi implements PoiInterface {

	private String name;
	private Address address;
	private String mainStreet;
	private Coordinate coordinate;
	private RangeOfAtention rangeOfAtention;
	private GoogleDistanceService googleService = GoogleDistanceService.getInstance();

	public Poi(String name, Address address, String mainStreet, Coordinate coordinate,
			RangeOfAtention rangeOfAtention) {
		super();
		this.name = name;
		this.address = address;
		this.mainStreet = mainStreet;
		this.coordinate = coordinate;
		this.rangeOfAtention = rangeOfAtention;
		this.googleService = googleService;
	}

	public GoogleDistanceService getGoogleService() {
		return googleService;
	}

	public void setGoogleService(GoogleDistanceService googleService) {
		this.googleService = googleService;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RangeOfAtention getRangeOfAtention() {
		return rangeOfAtention;
	}

	public void setRangeOfAtention(RangeOfAtention rangeOfAtention) {
		this.rangeOfAtention = rangeOfAtention;
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

	public boolean isEnable() {
		Date dateTime = new Date();
		if (!dateTime.before(rangeOfAtention.getMaxHourOfAtention())
				&& (!dateTime.after(rangeOfAtention.getMinHourOfAtention()))) {
			return false;
		} else {
			SimpleDateFormat dateFormat = new SimpleDateFormat("EEEEE");
			for (String currentDay : rangeOfAtention.getDaysWithoutAtention()) {
				if (dateFormat.format(dateTime) == currentDay) {
					return false;
				}
			}
			return true;
		}
	}

	public boolean isNearby(Coordinate cordinate) throws ClientProtocolException, IOException {
		return this.googleService.getDistance(this.coordinate, cordinate) < 500;
	}
}
