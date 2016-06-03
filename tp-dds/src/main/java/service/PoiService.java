package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import domain.Coordinate;
import domain.Holidays;
import externalServices.BankDTO;
import externalServices.BankService;
import poi.Bank;
import poi.Poi;

public class PoiService {

	private static PoiService instance = null;
	private static List<Poi> allPois;
	private static BankService bankService;
	
	
	
	public static PoiService getInstance() {
		if (instance == null) {
			instance = new PoiService();
			allPois=new ArrayList<Poi>();
			bankService= BankService.getInstance();
		}
		return instance;
	}
	

	public List<Poi> getAllPois() {
		return allPois;
	}

	public void setAllPois(List<Poi> allPois) {
		this.allPois = allPois;
	}

	public String poiType(Poi poi) {
		return poi.getType();
	}


	public boolean isNearby(Poi poi1, Coordinate coordinates) throws ClientProtocolException, IOException {
		return poi1.isNearby(coordinates);
	}

	public boolean isAvailable(Poi poi) {
		return poi.isAvailable();
	}
	public List<Poi> searchPois(String string){
		List<Poi> pois=new ArrayList<Poi>();
		for (Poi poi : allPois) {
			for (String text : poi.getData()) {
				if(text.contains(string)){
					pois.add(poi);
				}				
			}
		}
		pois.addAll(getBanksFromExternalService("", ""));
		return pois;
	}
	
	public List<Bank> searchBank(String bank, String service){
		return getBanksFromExternalService(bank, service);
		
	}
	
	public List<Bank> getBanksFromExternalService(String bank, String service){
		return bankService.getBanksFromService(bank,service);
	}
}
