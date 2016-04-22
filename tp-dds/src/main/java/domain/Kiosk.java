package domain;

public class Kiosk implements CategoryType{
	
	
	
	public boolean isNearby(Cordinate cordinateMachine,Poi unPoi) {
		return (Math.pow((unPoi.cordinate.getLatitude()-cordinateMachine.getLatitude()),2)+Math.pow((unPoi.cordinate.getLength()-cordinateMachine.getLength()), 2))<2;
	}


	
	
	

}
