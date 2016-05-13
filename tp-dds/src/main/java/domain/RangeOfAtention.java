package domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RangeOfAtention {

	private Date minHourOfAtention;
	private Date maxHourOfAtention;
	private List<String> daysWithoutAtention;

	public RangeOfAtention(String MinHourOfAtention, String MaxHourOfAtention, List<String> daysOfAtention) {
		SimpleDateFormat parser = new SimpleDateFormat("HH:mm");
		try {
			maxHourOfAtention = parser.parse(MaxHourOfAtention);
			minHourOfAtention= parser.parse(MinHourOfAtention);
			this.daysWithoutAtention = daysOfAtention;
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public Date getMinHourOfAtention() {
		return minHourOfAtention;
	}

	public void setMinHourOfAtention(Date minHourOfAtention) {
		this.minHourOfAtention = minHourOfAtention;
	}

	public Date getMaxHourOfAtention() {
		return maxHourOfAtention;
	}

	public void setMaxHourOfAtention(Date maxHourOfAtention) {
		this.maxHourOfAtention = maxHourOfAtention;
	}

	public List<String> getDaysWithoutAtention() {
		return daysWithoutAtention;
	}

	public void setDaysWithoutAtention(List<String> daysWithoutAtention) {
		this.daysWithoutAtention = daysWithoutAtention;
	}


}
