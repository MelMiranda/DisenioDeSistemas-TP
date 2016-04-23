package domainPOI;

import java.util.ArrayList;

public abstract class CGP extends Poi{
	
	private int areaBoundedByCommune;
	private ArrayList<CGPService> service;

	
	
	public boolean isNearBy(Coordinate cordinateMachine) {
		return (Math.pow((this.cordinate.getLatitude()-cordinateMachine.getLatitude()),2)+Math.pow((this.cordinate.getLongitude()-cordinateMachine.getLongitude()), 2))<areaBoundedByCommune;
	}
	
	public String getType(){
		return "CGP";
	}
	
	public boolean isEnable(){
		return true;//TO DO
	}
	
	
	

	
	
	


}
