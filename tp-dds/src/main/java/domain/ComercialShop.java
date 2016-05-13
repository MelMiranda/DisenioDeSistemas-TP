package domain;

import java.io.IOException;
import java.util.Date;

import org.apache.http.client.ClientProtocolException;

import poi.CategoryType;
import poi.Poi;

public class ComercialShop extends Poi {

	private Date minCloseInterval;
	private Date maxCloseInterval;
	private CategoryType categoryType;

	public ComercialShop(String name, Address address, String mainStreet, Coordinate coordinate,
			RangeOfAtention rangeOfAtention, Date minCloseInterval, Date maxCloseInterval, CategoryType category) {
		super(name, address, mainStreet, coordinate, rangeOfAtention);

		this.minCloseInterval = minCloseInterval;
		this.maxCloseInterval = maxCloseInterval;
		this.categoryType = category;
	}

	public String getType() {
		return "Comercial";
	}

	public boolean isEnable() {
		Date dateTime = new Date();

		boolean isEnable = super.isEnable();
		if (!dateTime.before(minCloseInterval) || (!dateTime.after(maxCloseInterval))) {
			return false;
		} else {
			return isEnable;
		}
	}

	@Override
	public boolean isNearBy(Coordinate coordinatePoiService) throws ClientProtocolException, IOException {
		return categoryType.isNearBy(coordinatePoiService, this.getCoordinate(), this.getGoogleService());
	}

}
