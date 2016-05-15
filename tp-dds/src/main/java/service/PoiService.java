package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import domain.Coordinate;
import poi.Poi;

public class PoiService {

	private Coordinate coordinates;
	private List<Poi> allPois=new ArrayList<Poi>();
	

	public List<Poi> getAllPois() {
		return allPois;
	}

	public void setAllPois(List<Poi> allPois) {
		this.allPois = allPois;
	}

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

	public boolean isAvailable(Poi poi) {
		return poi.isAvailable();
	}
	public List<Poi> searchPois(String string){
		List<Poi> pois=new ArrayList<Poi>();
		for (Poi poi : allPois) {
			for (String text : poi.getData()) {
				if(text.equalsIgnoreCase(string)){
					pois.add(poi);
				}				
			}			
		}
		return pois;
	}	
}
