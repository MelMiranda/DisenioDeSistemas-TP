package poi;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import ExternService.GoogleService.GoogleDistanceService;
import domain.Coordinate;

public class SchoolLibrary implements CategoryType {

	private double distanceMaxInMetters;
	

	public SchoolLibrary(double distanceMaxInMetters) {
		super();
		this.distanceMaxInMetters = distanceMaxInMetters;
	}


	@Override
	public boolean isNearBy(Coordinate coordinatePoiService, Coordinate coordinatePoi,
			GoogleDistanceService googleService) throws ClientProtocolException, IOException {
		double distance=googleService.getDistance(coordinatePoiService, coordinatePoi);
		return distance<this.distanceMaxInMetters;
	}

}
