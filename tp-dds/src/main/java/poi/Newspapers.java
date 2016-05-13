package poi;

import java.io.IOException;
import java.util.Date;

import org.apache.http.client.ClientProtocolException;

import ExternService.GoogleService.GoogleDistanceService;
import domain.Coordinate;
import domain.RangeOfAtention;
import service.AvailabilityService;

public class Newspapers implements CategoryShop{
	private static Newspapers instance=null;
	
	private double distanceMaxInMetters;
	private RangeOfAtention rangeOfAtention;
	
	
	  protected Newspapers() {
	   }

	  public static Newspapers getInstance(double distanceMaxInMetters,RangeOfAtention rangeOfAtention)  {
	      if(instance == null) {
	         instance = new Newspapers();
	         instance.setDistanceMaxInMetters(distanceMaxInMetters);
	         instance.setRangeOfAtention(rangeOfAtention);
	         
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
	public boolean isAvailable(Date date, AvailabilityService availabilityService) {
		return availabilityService.isAvailability(date, this.rangeOfAtention);
	}

}
