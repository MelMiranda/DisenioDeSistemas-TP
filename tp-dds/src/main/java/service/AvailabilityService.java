package service;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import domain.RangeOfAtention;
import domain.Schedule;

public class AvailabilityService {

	private static AvailabilityService instance = null;
	private static final Logger LOGGER= LoggerFactory.getLogger(AvailabilityService.class);

	protected AvailabilityService() {
	}

	public static AvailabilityService getInstance() {
		if (instance == null) {
			instance = new AvailabilityService();
		}
		return instance;
	}
	
	public boolean isAvailability(RangeOfAtention range) {
		Date date= new Date();
		boolean isAvailability=false;
		

		if (range.getDaysOfAttention().contains(date.getDay())) {
			for (Schedule schedule : range.getSchedules()) {
				if(date.before(schedule.getHourMax()) && (date.after(schedule.getHourMin()))) {
					isAvailability= true;
				}
			}
		}
		return isAvailability;
	}
	
	

}
