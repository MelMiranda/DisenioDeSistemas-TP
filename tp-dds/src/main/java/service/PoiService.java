package service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.google.maps.GeoApiContext;

import domainPOI.Coordinate;
import domainPOI.Poi;

public class PoiService {
	private PoiDatabaseManager databaseManager;
	private SearchDatabaseManager searchDatabaseManager;
	private Coordinate coordinates;
	private GeoLocation geoLocation;
	
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
	
	public Coordinate poiCoordinate(Poi poi){
		return poi.getCoordinate();
	}
	public boolean areNear(Poi poi1, Poi poi2){
		return poi1.isNearBy(poi2.getCoordinate());
	}
	public boolean isNear(Poi poi1){
		return poi1.isNearBy(coordinates);
	}
	
	public boolean isEnable(Poi poi){
		return poi.isEnable();
	}
}
