package service;

import domainPOI.Coordinate;

//This class stores information about a location on Earth.  Locations are
//specified using latitude and longitude.  The class includes a method for
//computing the distance between two locations.

public class GeoLocation {
	public static final double RADIUS = 6371000; // Earth radius in meters

	// returns the distance in meters between this geo location and the given
	// other geo location

	public double distanceFrom(Coordinate coordinate1, Coordinate coordinate2) {
		double lat1 = Math.toRadians(coordinate1.getLatitude());
		double long1 = Math.toRadians(coordinate1.getLongitude());
		double lat2 = Math.toRadians(coordinate2.getLatitude());
		double long2 = Math.toRadians(coordinate2.getLongitude());
		// apply the spherical law of cosines with a triangle composed of the
		// two locations and the north pole
		double theCos = Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1)
				* Math.cos(lat2) * Math.cos(long1 - long2);
		double arcLength = Math.acos(theCos);
		return arcLength * RADIUS;
	}
	
	public boolean insideCircleRange(Coordinate coordinateCircle, Coordinate coordinate, double radius){
		double deltaX=coordinateCircle.getLatitude()-coordinate.getLatitude();
		double deltaY=coordinateCircle.getLongitude() -coordinate.getLongitude();
		 return ((Math.sqrt (Math.pow(deltaX,2) + Math.pow(deltaY,2))) <= radius);
		
	}
}