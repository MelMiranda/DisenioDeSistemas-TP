package domainPOI;

public interface PoiInterface {
	
	boolean isEnable();
	String getType();
	boolean isNearBy(Coordinate coordinate);
	
}
