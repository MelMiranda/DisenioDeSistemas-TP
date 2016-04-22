package domain;

public class Bookstores implements CategoryType {
	
	
	
	public boolean isNearby(Cordinate cordinateMachine,Poi unPoi) {
		return (Math.pow((unPoi.cordinate.getLatitude()-cordinateMachine.getLatitude()),2)+Math.pow((unPoi.cordinate.getLength()-cordinateMachine.getLength()), 2))<=5;
	}

}
