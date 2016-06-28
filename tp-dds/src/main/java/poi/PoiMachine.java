package poi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import domain.Coordinate;
import internalService.PoiService;

public class PoiMachine {
	
	
	private Coordinate coordinates;
	private PoiService poiService;
	
	
	public Coordinate getCoordinates() {
		return coordinates;
	}


	public void setCoordinates(Coordinate coordinates) {
		this.coordinates = coordinates;
	}
	
	public List<Poi> searchPois(String string){
		return poiService.searchPois(string);
	}
	
	
	public List<Bank> searchBank(String bank, String service){
		return poiService.searchBank(bank, service);
		
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
	
	public boolean isAvailable(Poi poi) {
		return poiService.isAvailable(poi);
	}
	
	
	
	
	public boolean isNearBy(Poi poi) throws ClientProtocolException, IOException{
		return poiService.isNearby(poi, coordinates);
	}

}
