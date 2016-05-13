package poi;

import java.io.IOException;
import java.util.Date;

import org.apache.http.client.ClientProtocolException;

import domain.Address;
import domain.Coordinate;

public class ComercialShop extends Poi {

	private CategoryShop category;

	public ComercialShop(String name, Address address, Coordinate coordinate, CategoryShop category) {
		super(name, address, coordinate);

		this.category = category;
	}

	public String getType() {
		return "Comercial";
	}


	@Override
	public boolean isNearby(Coordinate coordinatePoiService) throws ClientProtocolException, IOException {
		return category.isNearby(coordinatePoiService, this.getCoordinate(), this.getGoogleService());
	}

	@Override
	public boolean isAvailable() {
		return category.isAvailable(this.getAvailabilityService());
	}

}
