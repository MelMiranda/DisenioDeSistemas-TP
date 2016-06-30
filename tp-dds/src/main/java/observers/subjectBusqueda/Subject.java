package observers.subjectBusqueda;

import java.util.List;

import observers.busqueda.ObserverBusqueda;
import poi.Poi;

public interface Subject {
	
	void agregarObservador(ObserverBusqueda observer, List<ObserverBusqueda> observers);
	public void eliminarObservador();
	public void notifiicarObservador(String string, String nombreTerminal, List<Poi> pois);

}
