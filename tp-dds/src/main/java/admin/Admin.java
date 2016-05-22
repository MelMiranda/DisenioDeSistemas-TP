package admin;

import domain.Schedule;
import poi.CGP;
import poi.CGPService;
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
	
	
	public boolean addCGPServiceToCGP(String cgpName, CGPService cgpService){
		
		for(Poi currentPoi: poiService.getAllPois()){
			if(currentPoi.getName().equalsIgnoreCase(cgpName) && currentPoi.getType().equalsIgnoreCase("CGP")){
				
				CGP cgp= (CGP) currentPoi;
				cgp.addService(cgpService);
				return true;
			}
			}
		return false;
		
		}
	
	public boolean addScheduleToCGPService(String nameOfCGP,String serviceName,String hourMax,String hourMin){
		
		for(Poi currentPoi: poiService.getAllPois()){
			if(currentPoi.getType()=="CGP" && currentPoi.getName().equalsIgnoreCase(nameOfCGP)){
				CGP cgp= (CGP) currentPoi;
				for(CGPService currentService :cgp.getServices()){
					if(currentService.getServiceName().equalsIgnoreCase(serviceName)){
						Schedule schedule = new Schedule(hourMin,hourMax);
						currentService.getRangeOfAtention().addSchedule(schedule);
						return true;
					}
				}
			}
		}
		return false;
		
	}
		
	

}
