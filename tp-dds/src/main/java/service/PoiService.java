package service;

import java.io.IOException;
import java.util.Date;
import org.apache.http.client.ClientProtocolException;
import domain.Coordinate;
import poi.Poi;

public class PoiService {

	private Coordinate coordinates;

	public String poiType(Poi poi) {
		return poi.getType();
	}

	public PoiService(Coordinate coordinates) {
		super();
		this.coordinates = coordinates;
	}

	public boolean isNearby(Poi poi1) throws ClientProtocolException, IOException {
		return poi1.isNearby(this.coordinates);
	}

	public boolean isavailable(Poi poi, Date date) {
		return poi.isAvailable(date);
	}
}
