package domainPOI;

public class Comercial extends Poi {
	
	private int distanceProximity;
	
	public Comercial(int aDistanceOfProximity){
		distanceProximity=aDistanceOfProximity;	
	}
	
	public boolean isNearBy(Coordinate cordinateMachine) {
		return (Math.pow((this.getCordinate().getLatitude()-cordinateMachine.getLatitude()),2)+Math.pow((this.getCordinate().getLongitude()-cordinateMachine.getLongitude()), 2))<distanceProximity;
	}
	
	public String getType(){
		return "Comercial";
	}
	
	public boolean isEnable(){
		return true;//TO DO
	}


}
