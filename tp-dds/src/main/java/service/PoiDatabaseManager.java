package service;

import java.util.ArrayList;
import java.util.List;

import domainPOI.Poi;

public class PoiDatabaseManager {
	
	List<Poi> allPois= new ArrayList<Poi>();

	public List<Poi> searchPoi(String poiName){
		List<Poi> searcheasPoi= new ArrayList<Poi>();
		for(Poi currentPoi: allPois){
			if((currentPoi.getName() == poiName)  || (currentPoi.getType()== poiName)){
				searcheasPoi.add(currentPoi);
			}
		}
		return searcheasPoi;
	}
	
	public void addPoi(Poi poiToAdd){
	allPois.add(poiToAdd);
	}
	


}
