package domainPOI;

public class BusStation extends Poi {
	

	
	public boolean isNearBy(Coordinate cordinateMachine) {
		return (Math.pow((this.cordinate.getLatitude()-cordinateMachine.getLatitude()),2)+Math.pow((this.cordinate.getLongitude()-cordinateMachine.getLongitude()), 2))<1;
	}
	
	public boolean isEnable(){
		return true;
		
	}
	
	public String getType(){
		return "Bus Station";
	}
	

}
