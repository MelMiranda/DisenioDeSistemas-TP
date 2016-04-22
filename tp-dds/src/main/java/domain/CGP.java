package domain;

import java.util.ArrayList;

public class CGP extends Poi{
	
	private int areaBoundedByCommune;
	private ArrayList<CGPService> service;
	
	
	
	public boolean isNearby(Cordinate cordinateMachine) {
		return (Math.pow((this.cordinate.getLatitude()-cordinateMachine.getLatitude()),2)+Math.pow((this.cordinate.getLength()-cordinateMachine.getLength()), 2))<areaBoundedByCommune;
	}
	

	
	
	


}
