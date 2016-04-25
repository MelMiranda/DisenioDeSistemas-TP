package domainPOI;


public abstract class Poi implements PoiInterface {
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
		return (geoLocation.distanceFrom(this.coordinate, aCoordinate)<500);
	}

	
	public boolean isEnable(){
		return true; //TO DO
	}
	
	/*public List<String> getMainInfo(){
		
	}*/
	
	
	
	
//falta unidad, preguntar si es lo mismo que numero de departamento
}
