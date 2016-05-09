package appiGoogle.service;

import java.io.InputStreamReader;

import json.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;

import appiGoogle.ApiDirectionsGoogleDTO;

public class TransformToApiGoogleDto {
	
	

	
	public ApiDirectionsGoogleDTO transform(InputStreamReader input){
		JsonFactory jsonFactory=new JsonFactory();
		
		return jsonFactory.fromJson(input, new TypeReference<ApiDirectionsGoogleDTO>() {
		});		
		
	}
}
