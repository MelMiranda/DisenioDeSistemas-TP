package domainPOI;

import java.text.SimpleDateFormat;
import java.util.Date;


public abstract class Poi implements PoiInterface {
	
	protected String name;
	protected Address address;
	protected String mainStreet;
	protected Coordinate coordinate;
	protected RangeOfAtention rangeOfAtention;
		
	
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

	//public boolean isNearBy(Coordinate aCoordinate) {
	//	return (geoLocation.distanceFrom(this.coordinate, aCoordinate) < 500);
	//}


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

	
	
	
	public Poi(String name, Address address, String mainStreet, Coordinate coordinate,
			RangeOfAtention rangeOfAtention) {
		super();
		this.name = name;
		this.address = address;
		this.mainStreet = mainStreet;
		this.coordinate = coordinate;
		this.rangeOfAtention = rangeOfAtention;
	}

	public String getUrl(Coordinate c1, Coordinate c2){
	//	String ur2l="https://maps.googleapis.com/maps/api/distancematrix/json?origins=-34.8116466,-58.4514427&destinations=-34.8148093,-58.4531344&key=AIzaSyADv7wpbNqFOLDQjNXGXEcM1oAhCDEJHzw";
		String url="https://maps.googleapis.com/maps/api/distancematrix/json?origins="+c1.getLongitude()+","+c1.getLatitude()+"&destinations="+c2.getLongitude()+","+c2.getLatitude()+"&key=AIzaSyADv7wpbNqFOLDQjNXGXEcM1oAhCDEJHzw";
		return url;
	}
}
		
	
