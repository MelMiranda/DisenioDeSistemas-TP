package poi;

import java.io.IOException;
import java.util.Date;

import org.apache.http.client.ClientProtocolException;

import ExternService.GoogleService.GoogleDistanceService;
import domain.Coordinate;
import internalService.AvailabilityService;

public interface CategoryShop {

	
	public boolean isNearby(Coordinate coordinatePoiService, Coordinate coordinate,
			GoogleDistanceService googleService) throws ClientProtocolException, IOException;

	public boolean isAvailable(AvailabilityService availabilityService);
	public String getType();

}
