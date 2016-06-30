package internalService;

import java.util.ArrayList;
import java.util.List;

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

}
