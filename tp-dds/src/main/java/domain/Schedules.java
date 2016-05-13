package domain;

public class Schedules {
	
	private String hourMax;
	private String hourMin;
	
	
	public String getHourMax() {
		return hourMax;
	}
	public void setHourMax(String hourMax) {
		this.hourMax = hourMax;
	}
	public String getHourMin() {
		return hourMin;
	}
	public void setHourMin(String hourMin) {
		this.hourMin = hourMin;
	}
	public Schedules(String hourMax, String hourMin) {
		super();
		this.hourMax = hourMax;
		this.hourMin = hourMin;
	}
	
	
	
	

}
