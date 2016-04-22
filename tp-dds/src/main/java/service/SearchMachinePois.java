package service;

import domain.Cordinate;
import domain.Poi;

public class SearchMachinePois {
	
	private Cordinate cordinates;
	
	
	
	
	
	private boolean isNearby(Poi unPoi){
		return unPoi.isNearby(cordinates);
	}
	
	
	private boolean isAvailable(Poi unPoi){
		
		
		return true;
		
	}

}
