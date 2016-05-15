package poi;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import service.PoiService;
import domain.Coordinate;

public class PoiMachine {
	
	
	private Coordinate coordinates;
	private PoiService poiService;
	
	
	
	
	public Coordinate getCoordinates() {
		return coordinates;
	}




	public void setCoordinates(Coordinate coordinates) {
		this.coordinates = coordinates;
	}




	public PoiService getPoiService() {
		return poiService;
	}




	public void setPoiService(PoiService poiService) {
		this.poiService = poiService;
	}




	public PoiMachine(Coordinate coordinates){
		this.coordinates=coordinates;
		poiService= PoiService.getInstance();
		
	}
	
	public boolean isNearBy(Poi poi) throws ClientProtocolException, IOException{
		return poiService.isNearby(poi, coordinates);
	}

}
