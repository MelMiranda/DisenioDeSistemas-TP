package internalService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.security.auth.Subject;

import org.apache.http.client.ClientProtocolException;

import Dto.bankDto.BankDTO;
import domain.Coordinate;
import domain.Holidays;
import externalServices.BankService.BankService;
import observers.subjectBusqueda.SubjectBusquedas;
import poi.Bank;
import poi.Poi;

public class PoiService {

	private static PoiService instance = null;
	private static List<Poi> allPois;
	private static BankService bankService;
	private SubjectBusquedas subjectBusquedas = SubjectBusquedas.getInstance();
	private static ReportService reportService;

	public static PoiService getInstance() {
		if (instance == null) {
			instance = new PoiService();
			allPois = new ArrayList<Poi>();
			bankService = BankService.getInstance();
			reportService=ReportService.getInstance();
		}
		return instance;
	}

	public void removeAllPois() {
		this.allPois.clear();
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

	public List<Poi> searchPois(String string, String nombreTerminal) {
		List<Poi> pois = new ArrayList<Poi>();
		for (Poi poi : allPois) {
			for (String text : poi.getData()) {
				if (text.contains(string)) {
					pois.add(poi);
				}
			}
		}
		this.subjectBusquedas.notifiicarObservador(string, nombreTerminal, pois);
		return pois;
	}

	public List<Bank> searchBank(String bank, String service) {
		return getBanksFromExternalService(bank, service);

	}
	
	public Map<String,Integer> obtenerReportesFecha(){
		return reportService.getReportesTotalesPorFecha();
	}
	
	

	public List<Bank> getBanksFromExternalService(String bank, String service) {
		return bankService.getBanksFromService(bank, service);
	}
}
