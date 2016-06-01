package externalServices;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;

import com.fasterxml.jackson.core.type.TypeReference;

import reader.URLReader;
import json.JsonFactory;

public class BankService {
	
	private static BankService instance=null;
	
	public static BankService getInstance(){
		if(instance==null){
			instance= new BankService() ;
			return instance;
		}else{
			return instance;
		}
	}

	public List<BankDTO> getBanksFromService(String bank, String service) {
		List<BankDTO> banks = null;
		JsonFactory jsonFactory = new JsonFactory();
		URLReader urlReader = new URLReader();
		String url = "http://private-96b476-ddsutn.apiary-mock.com/banks?banco=" +bank + "&servicio=" + service;
		try {
			banks = jsonFactory.fromJson(urlReader.getStringFromURL(url),
					new TypeReference<ArrayList<BankDTO>>() {
					});
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return banks;
	}

}
