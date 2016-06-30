package observers.busqueda;

import internalService.ReportService;

public class AlmacenarResultado implements ObserverBusqueda {
	
	private ReportService reportService=ReportService.getInstance();




	@Override
	public void update(String palabraBuscada, String nombreTerminal, int cantPoisBusqueda) {
		reportService.addReporte(nombreTerminal, palabraBuscada, cantPoisBusqueda);		
	}

}
