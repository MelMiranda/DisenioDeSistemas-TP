package service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.RangeOfAtention;
import domain.Schedule;

public class AvailabilityService {

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
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);

		if (range.getDaysOfAttention().contains(cal.get(Calendar.DAY_OF_WEEK))) {
			for (Schedule schedule : range.getSchedules()) {
				String[] parts = schedule.getHourMax().split(":");
				int horaMax = Integer.parseInt(parts[0]);
				int minMax = Integer.parseInt(parts[1]);
				parts = schedule.getHourMin().split(":");
				int horaMin = Integer.parseInt(parts[0]);
				int minMin = Integer.parseInt(parts[1]);

				int minute = cal.get(Calendar.MINUTE);
				int currentHour = cal.get(Calendar.HOUR_OF_DAY);

				if (currentHour > horaMin && currentHour < horaMax) {
					return true;
				}
				if (currentHour == horaMin && minute >= minMin) {
					return true;
				}
				if (currentHour == horaMax && minute <= minMax) {
					return true;
				}

			}
			return false;

		}
		return false;
	}

}
