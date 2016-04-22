package domain;

public class Bank extends Poi {
	
	private RangeOfAtention rangeOfAtention;
	
	
	
	public Bank(RangeOfAtention rangeOfAtention) {
		super();
		this.rangeOfAtention = rangeOfAtention;
	}



	public boolean isNearby(Cordinate cordinatePoi) {
		return (Math.pow((this.cordinate.getLatitude()-cordinatePoi.getLatitude()),2)+Math.pow((this.cordinate.getLength()-cordinatePoi.getLength()), 2))<5;
	}



	public RangeOfAtention getRangeOfAtention() {
		return rangeOfAtention;
	}



	public void setRangeOfAtention(RangeOfAtention rangeOfAtention) {
		this.rangeOfAtention = rangeOfAtention;
	}

	
	
}
