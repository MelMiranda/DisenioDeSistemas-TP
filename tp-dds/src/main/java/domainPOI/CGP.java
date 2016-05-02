package domainPOI;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public abstract class CGP extends Poi{
	
	private int communeRadius;
	private ArrayList<CGPService> service;
	
	public boolean isNearBy(Coordinate coordinateMachine) {
		return geoLocation.distanceFrom(coordinate, coordinateMachine) < communeRadius;
	}
	
	public String getType(){
		return "CGP";
	}
	
	
		
		
	

}
