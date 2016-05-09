package domainPOI;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import http.HttpRequest;

public interface PoiInterface {
	
	boolean isEnable();
	boolean isNearBy(Coordinate coordinate,HttpRequest httpRequest) throws ClientProtocolException, IOException;
	public String getType();
}
