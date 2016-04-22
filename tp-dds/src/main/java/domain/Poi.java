package domain;


public class Poi {
	private String address;
	private String mainStreet;
	private String[] betweenStreets;
	private int addressNumber;
	private int floorNumber;
	private int departamentNumber;
	private int cp;
	private String location;
	private String neighborhood;
	private String province;
	private String country;
	protected Cordinate cordinate;
	
	
	private RangeOfAtention rangeOfAtention;	
	
	
	
	
	
	public Poi(String address, String mainStreet, String[] betweenStreets, int addressNumber, int floorNumber,
			int departamentNumber, int cp, String location, String neighborhood, String province, String country,
			Cordinate cordinate, RangeOfAtention rangeOfAtention) {
		super();
		this.address = address;
		this.mainStreet = mainStreet;
		this.betweenStreets = betweenStreets;
		this.addressNumber = addressNumber;
		this.floorNumber = floorNumber;
		this.departamentNumber = departamentNumber;
		this.cp = cp;
		this.location = location;
		this.neighborhood = neighborhood;
		this.province = province;
		this.country = country;
		this.cordinate = cordinate;
		this.rangeOfAtention = rangeOfAtention;
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
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMainStreet() {
		return mainStreet;
	}
	public void setMainStreet(String mainStreet) {
		this.mainStreet = mainStreet;
	}
	public String[] getBetweenStreets() {
		return betweenStreets;
	}
	public void setBetweenStreets(String[] betweenStreets) {
		this.betweenStreets = betweenStreets;
	}
	public int getAddressNumber() {
		return addressNumber;
	}
	public void setAddressNumber(int addressNumber) {
		this.addressNumber = addressNumber;
	}
	public int getFloorNumber() {
		return floorNumber;
	}
	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}
	public int getDepartamentNumber() {
		return departamentNumber;
	}
	public void setDepartamentNumber(int departamentNumber) {
		this.departamentNumber = departamentNumber;
	}
	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getNeighborhood() {
		return neighborhood;
	}
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}


	public Cordinate getCordinate() {
		return cordinate;
	}


	public void setCordinate(Cordinate cordinate) {
		this.cordinate = cordinate;
	}


	public boolean isNearby(Cordinate cordinatePoi) {
		return (Math.pow((this.cordinate.getLatitude()-cordinatePoi.getLatitude()),2)+Math.pow((this.cordinate.getLength()-cordinatePoi.getLength()), 2))<5;
	}

	
	
	
	
	
	
//falta unidad, preguntar si es lo mismo que numero de departamento
}
