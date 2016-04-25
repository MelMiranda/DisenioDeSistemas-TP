package domainPOI;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;

public class RangeOfAtention {

	private int minHourOfAtention;
	private int maxHourOfAtention;
	private List<String> daysOfAtention;

	public RangeOfAtention(int minHourOfAtention, int maxHourOfAtention, List<String> daysOfAtention) {
		super();
		this.minHourOfAtention = minHourOfAtention;
		this.maxHourOfAtention = maxHourOfAtention;
		this.daysOfAtention = daysOfAtention;
	}

	public int getMinHourOfAtention() {
		return minHourOfAtention;
	}

	public void setMinHourOfAtention(int minHourOfAtention) {
		this.minHourOfAtention = minHourOfAtention;
	}

	public int getMaxHourOfAtention() {
		return maxHourOfAtention;
	}

	public void setMaxHourOfAtention(int maxHourOfAtention) {
		this.maxHourOfAtention = maxHourOfAtention;
	}

	public List<String> getDaysOfAtention() {
		return daysOfAtention;
	}

	public void setDaysOfAtention(List<String> daysOfAtention) {
		this.daysOfAtention = daysOfAtention;
	}
	
}
