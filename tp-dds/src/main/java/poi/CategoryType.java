package poi;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import ExternService.GoogleService.GoogleDistanceService;
import domain.Coordinate;

public interface CategoryType {

	
	public boolean isNearBy(Coordinate coordinatePoiService, Coordinate coordinate,
			GoogleDistanceService googleService) throws ClientProtocolException, IOException;

}
