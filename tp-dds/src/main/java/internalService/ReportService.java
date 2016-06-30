package internalService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.LineaReporte;
import domain.ReporteFecha;
import domain.ReportePorTerminal;

public class ReportService {

	private static ReportService instance;
	private List<ReportePorTerminal> reportes = new ArrayList<ReportePorTerminal>();

	public static ReportService getInstance() {
		if (instance == null) {
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
		for (ReportePorTerminal currentReport : reportes) {
			if (currentReport.getNombreTerminal().equals(nombreTerminal)) {
				currentReport.agregarLineaMapa(cantPoisBusqueda, palabraBuscada);
			} else {
				ReportePorTerminal reporte = new ReportePorTerminal(nombreTerminal);
				reporte.agregarLineaMapa(cantPoisBusqueda, palabraBuscada);
				reportes.add(reporte);
			}
		}
	}

	public Object getReportesFecha() {

		Map<String, Integer> mapaResultados = new HashMap<String, Integer>();
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
					suma = n = lineaReporte.getCantPoisBusqueda();
					mapaResultados.put(date, suma);
				} else {
					mapaResultados.put(date, lineaReporte.getCantPoisBusqueda());
				}
			}
		}
		return mapaResultados;
	}
}
