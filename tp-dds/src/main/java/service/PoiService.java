package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import domain.Coordinate;
import http.HttpRequest;
import poi.Poi;

public class PoiService {
	private PoiDatabaseManager databaseManager;
	private SearchDatabaseManager searchDatabaseManager;
	
	
	private Coordinate coordinates;
	private HttpRequest httpRequest;
	
	

	
	public List<Poi> searchPoi(String poiName){
		saveSearch(poiName);
		return databaseManager.searchPoi(poiName);
	}
	
	public List<String> obtainPoiInformation(){
		return new ArrayList<String>();
	}
	
	private void saveSearch(String poiName){
		searchDatabaseManager.saveSearch(poiName);
	}

	public String poiType(Poi poi){
		return poi.getType();
	}
	

	public PoiService(Coordinate coordinates, HttpRequest httpRequest) {
		super();
		this.coordinates = coordinates;
		this.httpRequest = httpRequest;
	}



	public boolean isNearby(Poi poi1) throws ClientProtocolException, IOException{
		return poi1.isNearBy(this.coordinates);
	}
	
	public boolean isEnable(Poi poi){
		return poi.isEnable();
	}
}
