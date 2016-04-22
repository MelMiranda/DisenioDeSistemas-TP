package domain;

public class BusStop extends Poi {
	
	
	
	
	
	
	
	
	
	public boolean isNearby(Cordinate cordinateMachine) {
		return (Math.pow((this.cordinate.getLatitude()-cordinateMachine.getLatitude()),2)+Math.pow((this.cordinate.getLength()-cordinateMachine.getLength()), 2))<1;
	}
	
	public boolean isAvailable(){
		return true;
		
	}
	

}
