package service;

import domainPOI.Coordinate;
import domainPOI.Poi;

public class SearchMachinePois {
	
	private Coordinate cordinates;
	
	private boolean isNearby(Poi unPoi){
		return unPoi.isNearby(cordinates);
	}
	
	
	private boolean isAvailable(Poi unPoi){	
		return true;
		
	}

}
