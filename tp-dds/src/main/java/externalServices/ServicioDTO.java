package externalServices;

public class ServicioDTO {

	private String serviceName;
	private int day;
	private int sinceHour;
	private int sinceMinute;
	private int untilHour;
	private int untilMinute;

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getSinceHour() {
		return sinceHour;
	}

	public void setSinceHour(int sinceHour) {
		this.sinceHour = sinceHour;
	}

	public int getSinceMinute() {
		return sinceMinute;
	}

	public void setSinceMinute(int sinceMinute) {
		this.sinceMinute = sinceMinute;
	}

	public int getUntilHour() {
		return untilHour;
	}

	public void setUntilHour(int untilHour) {
		this.untilHour = untilHour;
	}

	public int getUntilMinute() {
		return untilMinute;
	}

	public void setUntilMinute(int untilMinute) {
		this.untilMinute = untilMinute;
	}

}
