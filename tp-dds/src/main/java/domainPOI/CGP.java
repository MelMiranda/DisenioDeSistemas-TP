package domainPOI;

import java.util.ArrayList;

public abstract class CGP extends Poi{
	
	private int communeRadius;
	private ArrayList<CGPService> service;
	

	
	
	public boolean isNearBy(Coordinate coordinateMachine) {
		return geoLocation.insideCircleRange(coordinate, coordinateMachine,communeRadius);
	}
	
	public String getType(){
		return "CGP";
	}
	
	public boolean isEnable(){
		return true;//TO DO
	}
	
	
	

	
	
	


}
