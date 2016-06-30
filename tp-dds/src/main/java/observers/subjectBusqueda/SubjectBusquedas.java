package observers.subjectBusqueda;

import java.util.ArrayList;
import java.util.List;

import observers.busqueda.AlmacenarResultado;
import observers.busqueda.NotificarAdmin;
import observers.busqueda.ObserverBusqueda;

public class SubjectBusquedas implements Subject {
	
	private static SubjectBusquedas instance;
	private List<ObserverBusqueda> observers=this.getObservers();
	
	public static SubjectBusquedas getInstance(){
		if(instance==null){
			return new SubjectBusquedas();
		}
			
		return instance;		
	}

	private List<ObserverBusqueda> getObservers() {
		List<ObserverBusqueda> observers=new ArrayList<ObserverBusqueda>();
		this.agregarObservador(new AlmacenarResultado(),observers);
		this.agregarObservador(new NotificarAdmin(),observers);
		return observers;
	}

	public void agregarObservador(ObserverBusqueda observer, List<ObserverBusqueda> observers) {
		observers.add(observer);
	}

	

	@Override
	public void eliminarObservador() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifiicarObservador() {
		// TODO Auto-generated method stub
		
	}

}
