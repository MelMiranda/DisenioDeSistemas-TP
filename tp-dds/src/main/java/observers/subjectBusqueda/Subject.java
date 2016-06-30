package observers.subjectBusqueda;

import java.util.List;

import observers.busqueda.ObserverBusqueda;

public interface Subject {
	
	void agregarObservador(ObserverBusqueda observer, List<ObserverBusqueda> observers);
	public void eliminarObservador();
	public void notifiicarObservador();

}
