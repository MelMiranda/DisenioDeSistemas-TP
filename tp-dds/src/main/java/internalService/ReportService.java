package internalService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.LineaReporte;
import domain.ReportePorTerminal;

public class ReportService {

	private static ReportService instance;
	private static List<ReportePorTerminal> reportes;
	private static Map<String, Integer> mapaResultados;

	public static ReportService getInstance() {
		if (instance == null) {
			reportes = new ArrayList<ReportePorTerminal>();
			mapaResultados=new HashMap<String, Integer>();
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

				if (mapaResultados.containsKey(date)) {
					n = mapaResultados.get(date);
					mapaResultados.remove(date);
					suma = n + lineaReporte.getCantPoisBusqueda();
					mapaResultados.put(date, suma);
				} else {
					mapaResultados.put(date, lineaReporte.getCantPoisBusqueda());
				}
			}
		}
		return mapaResultados;
	}

	public void resetReports() {
		reportes=new ArrayList<ReportePorTerminal>();
		
	}
}
