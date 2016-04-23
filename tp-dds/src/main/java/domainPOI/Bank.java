package domainPOI;

public class Bank extends Poi {
	
	private RangeOfAtention rangeOfAtention;
	
	
	
	public Bank(RangeOfAtention rangeOfAtention) {
		super();
		this.rangeOfAtention = rangeOfAtention;
	}



	public boolean isNearBy(Coordinate cordinatePoi) {
		return (Math.pow((this.cordinate.getLatitude()-cordinatePoi.getLatitude()),2)+Math.pow((this.cordinate.getLongitude()-cordinatePoi.getLongitude()), 2))<5;
	}



	public RangeOfAtention getRangeOfAtention() {
		return rangeOfAtention;
	}
	
	
	public void setRangeOfAtention(RangeOfAtention rangeOfAtention) {
		this.rangeOfAtention = rangeOfAtention;
	}
	
	public boolean isEnable(){
		return true; //TO DO
	}

	public String getType(){
		return "Bank";
	}
	
	
}
