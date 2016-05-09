package domainPOI;

import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.client.ClientProtocolException;

import appiGoogle.ApiDirectionsGoogleDTO;
import appiGoogle.service.TransformToApiGoogleDto;
import http.HttpRequest;

public class BusStation extends Poi {
	


	
	public boolean isEnable(){
		return true;
	}

	

	@Override
	public boolean isNearBy(Coordinate coordinate,HttpRequest httprequest) throws ClientProtocolException, IOException {
		TransformToApiGoogleDto transform =new TransformToApiGoogleDto();
		String url=this.getUrl(this.coordinate, coordinate);
		InputStreamReader input=httprequest.httpRequest(url);
		ApiDirectionsGoogleDTO dto=transform.transform(input);
		int distance=dto.getRows().get(0).getElements().get(0).getDistance().getValue();
		return distance<100;
	}



	public BusStation() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
