package internalService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.http.client.ClientProtocolException;
import domain.Coordinate;
import domain.Reloj;
import externalServices.BankService.BankService;
import observers.subjectBusqueda.SubjectBusquedas;
import poi.Bank;
import poi.Poi;
import utils.Esperar;

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
		allPois.clear();
	}

	public List<Poi> getAllPois() {
		return allPois;
	}

	public void setAllPois(List<Poi> allPois) {
		allPois = allPois;
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

	public List<Poi> searchPois(String string, String nombreTerminal) throws AddressException, MessagingException, InterruptedException {
		Reloj reloj=new Reloj();
		reloj.Contar();
		List<Poi> pois = new ArrayList<Poi>();
		for (Poi poi : allPois) {
			for (String text : poi.getData()) {
				if (text.contains(string)) {
					pois.add(poi);
				}
			}
		}
		
		Thread.sleep(5000);
		reloj.Detener();
		int segundosQueTardo=reloj.getSegundos();
		System.out.println("Segundoooos: "+segundosQueTardo);
		this.subjectBusquedas.notifiicarObservador(string, nombreTerminal, pois,segundosQueTardo);
		return pois;
	}

	public List<Bank> searchBank(String bank, String service) {
		return getBanksFromExternalService(bank, service);

	}
	
	public Map<String,Integer> getReportesTotalesPorFecha(){
		return reportService.getReportesTotalesPorFecha();
	}
	
	public Map<String, Integer> getParcialesPorTerminal(String nombreTerminal){
		return reportService.getParcialesPorTerminal(nombreTerminal);
	}

	public Map<String, Integer> getReportesTodasLasTerminales(){
		return this.reportService.getReportesTotalesTodasLasTerminales();
	}
	
	
	

	public List<Bank> getBanksFromExternalService(String bank, String service) {
		return bankService.getBanksFromService(bank, service);
	}
	
	
	public void resetReports(){
		reportService.resetReports();
		
	}

	public void resetAllPois() {
		allPois=new ArrayList<Poi>();
		
	}
}
