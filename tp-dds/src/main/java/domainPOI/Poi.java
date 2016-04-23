package domainPOI;


public abstract class Poi implements PoiInterface {
	protected String name;
	protected Address address;
	protected String mainStreet;
	protected Coordinate cordinate;
	protected RangeOfAtention rangeOfAtention;	


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



	public Coordinate getCordinate() {
		return cordinate;
	}


	public void setCordinate(Coordinate cordinate) {
		this.cordinate = cordinate;
	}


	public boolean isNearBy(Coordinate cordinatePoi) {
		return (Math.pow((this.cordinate.getLatitude()-cordinatePoi.getLatitude()),2)+Math.pow((this.cordinate.getLongitude()-cordinatePoi.getLongitude()), 2))<5;
	}

	
	public boolean isEnable(){
		return true; //TO DO
	}
	
	/*public List<String> getMainInfo(){
		
	}*/
	
	
	
	
//falta unidad, preguntar si es lo mismo que numero de departamento
}
