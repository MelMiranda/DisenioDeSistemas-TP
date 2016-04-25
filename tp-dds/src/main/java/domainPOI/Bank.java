package domainPOI;

public class Bank extends Poi {
	
	private RangeOfAtention rangeOfAtention;
	
	
	
	public Bank(RangeOfAtention rangeOfAtention) {
		super();
		this.rangeOfAtention = rangeOfAtention;
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
