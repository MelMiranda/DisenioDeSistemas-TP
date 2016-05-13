package domain;

import java.util.List;

public class RangeOfAtention2 {
		
	private List<Schedules> schedules;
	private List<String> daysOfAttention;
	
	
	public List<Schedules> getSchedules() {
		return schedules;
	}
	public void setSchedules(List<Schedules> schedules) {
		this.schedules = schedules;
	}
	public List<String> getDaysOfAttention() {
		return daysOfAttention;
	}
	public void setDaysOfAttention(List<String> daysOfAttention) {
		this.daysOfAttention = daysOfAttention;
	}
	public RangeOfAtention2(List<Schedules> schedules, List<String> daysOfAttention) {
		super();
		this.schedules = schedules;
		this.daysOfAttention = daysOfAttention;
	}
	
	
	
	

}
