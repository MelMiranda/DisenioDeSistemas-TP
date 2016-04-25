package domainPOI;

public class BusStation extends Poi {
	

	@Override
	public boolean isNearBy(Coordinate aCoordinate) {
		return (geoLocation.distanceFrom(coordinate, aCoordinate)<100);
	}
	
	public boolean isEnable(){
		return true;
	}

	
	public String getType(){
		return "Bus Station";
	}
	

}
