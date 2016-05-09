package domainPOI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Comercial extends Poi {
	
	private int distanceProximityRadius;
	private Date minCloseInterval;
	private Date maxCloseInterval;
	
	public Comercial(int numberOfStreetsNearly, String aMaxCloseInterval, String aMinCloseInterval){
		SimpleDateFormat parser = new SimpleDateFormat("HH:mm");
		distanceProximityRadius=numberOfStreetsNearly*100;	
		try {
			maxCloseInterval= parser.parse(aMaxCloseInterval);
			minCloseInterval= parser.parse(aMinCloseInterval);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	
	
	@Override
//	public boolean isNearBy(Coordinate coordinateMachine) {
//		return (geoLocation.distanceFrom(coordinate, coordinateMachine) < distanceProximityRadius);
//	}
	
	public String getType(){
		return "Comercial";
	}

	public boolean isEnable(){
		Date dateTime= new Date();
		
		boolean isEnable= super.isEnable();
		if (!dateTime.before(minCloseInterval)
				|| (!dateTime.after(maxCloseInterval))){
			return false;
		}else{
			return isEnable;
		}
	}



	@Override
	public boolean isNearBy(Coordinate coordinate) {
		// TODO Auto-generated method stub
		return false;
	}


}
