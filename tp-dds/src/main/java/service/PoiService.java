package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import domain.Coordinate;
import http.HttpRequest;
import poi.Poi;

public class PoiService {

	
	private Coordinate coordinates;
	private HttpRequest httpRequest;
	


	public String poiType(Poi poi){
		return poi.getType();
	}
	

	public PoiService(Coordinate coordinates) {
		super();
		this.coordinates = coordinates;
		this.httpRequest = httpRequest=new HttpRequest();
	}



	public boolean isNearby(Poi poi1) throws ClientProtocolException, IOException{
		return poi1.isNearBy(this.coordinates);
	}
	
	public boolean isEnable(Poi poi){
		return poi.isEnable();
	}
}
