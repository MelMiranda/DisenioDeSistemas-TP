package admin;

import poi.Poi;
import service.PoiService;

public class Admin {

	private PoiService poiService;

	public Admin() {
		poiService = PoiService.getInstance();
	}

	public boolean removePoi(String poiName) {
		int index = 0;
		for (Poi currentPoi : poiService.getAllPois()) {

			if (currentPoi.getName().equalsIgnoreCase(poiName)) {
				poiService.getAllPois().remove(index);
				return true;
			}
			index++;
		}
		return false;
	}

	public void addPoi(Poi poi) {
		poiService.getAllPois().add(poi);
	}

	
	//Consultar o interpretar otras formas.
	public boolean modifyPoi(Poi poi, String poiName) {

		for (Poi currentPoi : poiService.getAllPois()) {

			if (currentPoi.getName().equalsIgnoreCase(poiName)) {
				currentPoi = poi;
				return true;

			}

		}
		return false;
	}

}
