package internalService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import domain.LineaReporte;
import domain.ReportePorTerminal;

public class ReportService {

	private static ReportService instance;
	private static List<ReportePorTerminal> reportes;
	private static Map<String, Integer> mapaResultadosTotales;
	private static Map<String, Integer> mapaResultadoParcialPorTerminal;
	private static Map<String, Integer> mapaResultadoTotalesTodasLasTerminales;

	public static ReportService getInstance() {
		if (instance == null) {
			reportes = new ArrayList<ReportePorTerminal>();
			mapaResultadosTotales = new HashMap<String, Integer>();
			mapaResultadoParcialPorTerminal = new HashMap<String, Integer>();
			mapaResultadoTotalesTodasLasTerminales= new HashMap<String, Integer>();
			return new ReportService();
		}
		return instance;
	}

	public List<ReportePorTerminal> getReportes() {
		return reportes;
	}

	public void setReportes(List<ReportePorTerminal> reportes) {
		this.reportes = reportes;
	}

	public void addReporte(String nombreTerminal, String palabraBuscada, Integer cantPoisBusqueda) {
		int i = 0;
		for (ReportePorTerminal currentReport : reportes) {
			if (currentReport.getNombreTerminal().equals(nombreTerminal)) {
				currentReport.agregarReporteAterminal(cantPoisBusqueda, palabraBuscada);
				i = 1;
			}
		}
		if (i == 0) {
			ReportePorTerminal reporte = new ReportePorTerminal(nombreTerminal);
			reporte.agregarReporteAterminal(cantPoisBusqueda, palabraBuscada);
			reportes.add(reporte);
		}
	}

	public Map<String, Integer> getReportesTotalesPorFecha() {
		int n;
		int suma;
		for (ReportePorTerminal reportePorTerminal : reportes) {
			for (LineaReporte lineaReporte : reportePorTerminal.getBusquedas()) {
				Date fecha = lineaReporte.getFechaBusqueda();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
				String date = sdf.format(fecha);

				if (mapaResultadosTotales.containsKey(date)) {
					n = mapaResultadosTotales.get(date);
					mapaResultadosTotales.remove(date);
					suma = n + lineaReporte.getCantPoisBusqueda();
					mapaResultadosTotales.put(date, suma);
				} else {
					mapaResultadosTotales.put(date, lineaReporte.getCantPoisBusqueda());
				}
				n = 0;
			}
		}
		return mapaResultadosTotales;
	}

	public void resetReports() {
		reportes = new ArrayList<ReportePorTerminal>();
	}
	public void resetReportesTotales(){
		mapaResultadoParcialPorTerminal=new HashMap<String, Integer>();
	}
	

	public Map<String, Integer> getParcialesPorTerminal(String nombreTerminal) {
		int suma;
		int n;
		ReportePorTerminal reporte = this.buscarReporteTerminal(nombreTerminal);
		if (reporte != null) {
			for (LineaReporte lineaReporte : reporte.getBusquedas()) {
				Date fecha = lineaReporte.getFechaBusqueda();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
				String date = sdf.format(fecha);

				if (mapaResultadoParcialPorTerminal.containsKey(date)) {
					n = mapaResultadoParcialPorTerminal.get(date);
					mapaResultadoParcialPorTerminal.remove(date);
					suma = n + lineaReporte.getCantPoisBusqueda();
					mapaResultadoParcialPorTerminal.put(date, suma);
				} else {
					mapaResultadoParcialPorTerminal.put(date, lineaReporte.getCantPoisBusqueda());
				}
				n = 0;
			}
		}
		return mapaResultadoParcialPorTerminal;
	}

	private ReportePorTerminal buscarReporteTerminal(String nombreTerminal) {
		ReportePorTerminal reporte = null;
		for (ReportePorTerminal reportePorTerminal : reportes) {
			if (reportePorTerminal.getNombreTerminal().equals(nombreTerminal)) {
				reporte = reportePorTerminal;
			}
		}
		return reporte;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Integer> getReportesTotalesTodasLasTerminales() {
		this.resetReportesTotales();
		int suma;
		for (ReportePorTerminal reportePorTerminal : reportes) {
			Map<String, Integer> resultadosPorTerminal = this
					.getParcialesPorTerminal(reportePorTerminal.getNombreTerminal());
			suma = 0;

			List<String> keys = new ArrayList<String>();
			
			//flashada por que me ate mucho a los map, pero funciona
			for (final Iterator<java.util.Map.Entry<String, Integer>> it = resultadosPorTerminal.entrySet()
					.iterator(); it.hasNext();) {
				final java.util.Map.Entry<String, Integer> entry = it.next();
				final String numero = entry.getKey();
				keys.add(numero);
				;				
			}
			for (String key : keys) {
				suma = suma + resultadosPorTerminal.get(key);
			}
			mapaResultadoTotalesTodasLasTerminales.put(reportePorTerminal.getNombreTerminal(), suma);

		}
		return mapaResultadoTotalesTodasLasTerminales;
	}
}
