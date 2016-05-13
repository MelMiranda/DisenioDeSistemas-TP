package ExternService.GoogleService;

import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.client.ClientProtocolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.core.type.TypeReference;

import Dto.appiGoogleDTO.ApiDirectionsGoogleDTO;
import domain.Coordinate;
import http.HttpRequest;
import json.JsonFactory;

public class GoogleDistanceService {

	private static final Logger LOGGER = LoggerFactory.getLogger(GoogleDistanceService.class);
	private static GoogleDistanceService instance=null;
	
	  protected GoogleDistanceService() {
	      // Exists only to defeat instantiation.
	   }

	  public static GoogleDistanceService getInstance() {
	      if(instance == null) {
	         instance = new GoogleDistanceService();
	      }
	      return instance;
	   }


	public double getDistance(Coordinate cordinate1, Coordinate cordinate2)
			throws ClientProtocolException, IOException {
		String url = getUrl(cordinate1, cordinate2);

		HttpRequest httpRequest = new HttpRequest();

		ApiDirectionsGoogleDTO dto;
		JsonFactory jsonFactory = new JsonFactory();
		InputStreamReader input = httpRequest.request(url);
		dto = jsonFactory.fromJson(input, new TypeReference<ApiDirectionsGoogleDTO>() {
		});
		return dto.getRows().get(0).getElements().get(0).getDistance().getValue();

	}

	public String getUrl(Coordinate c1, Coordinate c2) {
		// String
		// url2="https://maps.googleapis.com/maps/api/distancematrix/json?origins=-34.8116466,-58.4514427&destinations=-34.8148093,-58.4531344&key=AIzaSyADv7wpbNqFOLDQjNXGXEcM1oAhCDEJHzw";
		String url = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=" + c1.getLongitude() + ","
				+ c1.getLatitude() + "&destinations=" + c2.getLongitude() + "," + c2.getLatitude()
				+ "&key=AIzaSyADv7wpbNqFOLDQjNXGXEcM1oAhCDEJHzw";
		LOGGER.info(url);
		return url;
	}

}
/*
 * public void httpRequest() throws ClientProtocolException, IOException {
 * String url=
 * "https://maps.googleapis.com/maps/api/distancematrix/json?origins=-34.8116466,-58.4514427&destinations=-34.8148093,-58.4531344&key=AIzaSyADv7wpbNqFOLDQjNXGXEcM1oAhCDEJHzw";
 * HttpClient clientHttp = HttpClientBuilder.create().build(); HttpGet request =
 * new HttpGet(url); HttpResponse response = clientHttp.execute(request);
 * 
 * 
 * 
 * InputStreamReader input=new
 * InputStreamReader(response.getEntity().getContent());
 * 
 * ApiDirectionsGoogleDTO dto; JsonFactory jsonFactory= new JsonFactory();
 * dto=jsonFactory.fromJson(input, new TypeReference<ApiDirectionsGoogleDTO>() {
 * });
 * 
 * LOGGER.info(dto.getOriginAddresses().get(0));
 * LOGGER.info(dto.getDestinationAddresses().get(0));
 * LOGGER.info(dto.getStatus());
 * //LOGGER.info(dto.getRows().get(0).getElements().get(0).getDistance().
 * getValue());
 * //LOGGER.info((dto.getRows().get(0).getDistance().getValue()).toString());
 * //System.err.println((dto.getRows().get(0).getDistance().getValue()));
 * System.out.println(dto.getRows().get(0).getElements().get(0).getDistance().
 * getValue());
 * System.out.println(dto.getRows().get(0).getElements().get(0).getDistance().
 * getText());
 * 
 * }
 */
