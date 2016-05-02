package domainPOI;

import java.text.SimpleDateFormat;
import java.util.Date;

import service.GeoLocation;

public abstract class Poi implements PoiInterface {
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public GeoLocation getGeoLocation() {
		return geoLocation;
	}

	public void setGeoLocation(GeoLocation geoLocation) {
		this.geoLocation = geoLocation;
	}

	protected String name;
	protected Address address;
	protected String mainStreet;
	protected Coordinate coordinate;
	protected RangeOfAtention rangeOfAtention;
	protected GeoLocation geoLocation;

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

	public boolean isNearBy(Coordinate aCoordinate) {
		return (geoLocation.distanceFrom(this.coordinate, aCoordinate) < 500);
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

	/*
	 * public List<String> getMainInfo(){
	 * 
	 * }
	 */

	// falta unidad, preguntar si es lo mismo que numero de departamento
}
