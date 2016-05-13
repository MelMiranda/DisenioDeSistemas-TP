package poi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import ExternService.GoogleService.GoogleDistanceService;
import domain.Coordinate;
import domain.RangeOfAtention;
import domain.Schedule;
import service.AvailabilityService;

public class Newspapers implements CategoryShop{
	private static Newspapers instance=null;
	
	private double distanceMaxInMetters;
	private RangeOfAtention rangeOfAtention;
	
	
	
	  protected Newspapers() {
	   }

	  public static Newspapers getInstance(double distanceMaxInMetters)  {
	      if(instance == null) {
	         instance = new Newspapers();
	         instance.setDistanceMaxInMetters(distanceMaxInMetters);
	         
	         setRangeOfAtention();
	      }
	      return instance;
	   }

	
	
	public double getDistanceMaxInMetters() {
		return distanceMaxInMetters;
	}

	public void setDistanceMaxInMetters(double distanceMaxInMetters) {
		this.distanceMaxInMetters = distanceMaxInMetters;
	}

	public RangeOfAtention getRangeOfAtention() {
		return rangeOfAtention;
	}

	public void setRangeOfAtention(RangeOfAtention rangeOfAtention) {
		this.rangeOfAtention = rangeOfAtention;
	}

	public Newspapers(double distanceMaxInMetters) {
		super();
		this.distanceMaxInMetters = distanceMaxInMetters;
	}

	@Override
	public boolean isNearby(Coordinate coordinatePoiService, Coordinate coordinatePoi,
			GoogleDistanceService googleService) throws ClientProtocolException, IOException {
		double distance=googleService.getDistance(coordinatePoiService, coordinatePoi);
		return distance<this.distanceMaxInMetters;
	}

	@Override
	public boolean isAvailable(AvailabilityService availabilityService) {
		return availabilityService.isAvailability(this.rangeOfAtention);
	}
	
	private static void setRangeOfAtention(){
		
		List<Schedule> schedules= new ArrayList<Schedule>();
        Schedule schedule= new Schedule("10:00","18:00");
        schedules.add(schedule);
        List<Integer> days= new ArrayList<Integer>();
        days.add(1);
        days.add(2);
        days.add(3);
        days.add(4);
        days.add(5);
        instance.setRangeOfAtention(new RangeOfAtention(schedules,days));
	}

}
