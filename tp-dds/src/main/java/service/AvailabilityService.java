package service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.RangeOfAtention;

public class AvailabilityService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AvailabilityService.class);
	private static AvailabilityService instance = null;

	protected AvailabilityService() {
	}

	public static AvailabilityService getInstance() {
		if (instance == null) {
			instance = new AvailabilityService();
		}
		return instance;
	}

	public boolean isAvailability(Date date, RangeOfAtention range) {

		/*
		 * GregorianCalendar cal = new GregorianCalendar(); cal.setTime(date);
		 * cal.get(Calendar.DAY_OF_WEEK);
		 */

		return true;
	}

}
