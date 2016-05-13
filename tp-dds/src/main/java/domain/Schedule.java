package domain;

public class Schedule {

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

	public Schedule(String hourMin, String hourMax) {
		this.hourMax = hourMax;
		this.hourMin =  hourMin;
	}

	

}
