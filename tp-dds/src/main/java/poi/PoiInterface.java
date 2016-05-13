package poi;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import domain.Coordinate;


public interface PoiInterface {
	
	boolean isEnable();
	boolean isNearBy(Coordinate coordinate) throws ClientProtocolException, IOException;
	public String getType();
}
