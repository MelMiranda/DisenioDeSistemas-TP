package domainPOI;

public class Comercial extends Poi {
	
	private int distanceProximityRadius;

	
	public Comercial(int numberOfStreetsNearly){
		distanceProximityRadius=numberOfStreetsNearly*100;	
	}
	
	@Override
	public boolean isNearBy(Coordinate cordinateMachine) {
		return geoLocation.insideCircleRange(coordinate, cordinateMachine, distanceProximityRadius);
	}
	
	public String getType(){
		return "Comercial";
	}
	
	public boolean isEnable(){
		return true;//TO DO
	}


}
