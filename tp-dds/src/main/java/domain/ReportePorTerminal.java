package domain;

import java.util.ArrayList;
import java.util.List;


import org.joda.time.DateTime;

public class ReportePorTerminal {
	
	private String nombreTerminal;
	private List<LineaReporte> busquedas=new ArrayList<LineaReporte>();
	
	public String getNombreTerminal() {
		return nombreTerminal;
	}
	public void setNombreTerminal(String nombreTerminal) {
		this.nombreTerminal = nombreTerminal;
	}

	public List<LineaReporte> getBusquedas() {
		return busquedas;
	}
	public void setBusquedas(List<LineaReporte> busquedas) {
		this.busquedas = busquedas;
	}
	
	public void agregarLineaMapa(int cantPoisBusqueda) {
		busquedas.add(new LineaReporte(new DateTime(), cantPoisBusqueda));
		
	}

	
	
}
