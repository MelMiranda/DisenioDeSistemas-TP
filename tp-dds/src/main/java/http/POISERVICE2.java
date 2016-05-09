package http;

import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.core.type.TypeReference;

import appiGoogle.ApiDirectionsGoogleDTO;
import json.JsonFactory;

public class POISERVICE2 {
	private static final Logger LOGGER = LoggerFactory.getLogger(POISERVICE2.class);

	
	
	
	

	
	
	
	
	public void httpRequest() throws ClientProtocolException, IOException {
		String url="https://maps.googleapis.com/maps/api/distancematrix/json?origins=-34.8116466,-58.4514427&destinations=-34.8148093,-58.4531344&key=AIzaSyADv7wpbNqFOLDQjNXGXEcM1oAhCDEJHzw";
		HttpClient clientHttp = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);
		HttpResponse response = clientHttp.execute(request);
	
		
		
		InputStreamReader input=new InputStreamReader(response.getEntity().getContent());
		
		ApiDirectionsGoogleDTO dto;
		JsonFactory jsonFactory= new JsonFactory();
		dto=jsonFactory.fromJson(input, new TypeReference<ApiDirectionsGoogleDTO>() {
		});
		
		LOGGER.info(dto.getOriginAddresses().get(0));
		LOGGER.info(dto.getDestinationAddresses().get(0));		
		LOGGER.info(dto.getStatus());	
		//LOGGER.info(dto.getRows().get(0).getElements().get(0).getDistance().getValue());
		//LOGGER.info((dto.getRows().get(0).getDistance().getValue()).toString());
		//System.err.println((dto.getRows().get(0).getDistance().getValue()));
		System.out.println(dto.getRows().get(0).getElements().get(0).getDistance().getValue());
		System.out.println(dto.getRows().get(0).getElements().get(0).getDistance().getText());
	
	}
	
	public static void main(String[] args) throws ClientProtocolException, IOException {
		POISERVICE2 poi =new POISERVICE2();
				poi.httpRequest();
	}

	
	
	
	
	
	
}
