import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import Dto.cgpLimitPointsDto.CiudadesDto;
import Dto.cgpLimitPointsDto.parseCiudadDtoJson;

public class Prueba2 {
	

	
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		parseCiudadDtoJson parse=new parseCiudadDtoJson();
		CiudadesDto c=parse.parseJson();
		
		System.out.println(c.getCiudades().get(0).getLimitPoints().get(1));
	
	}
	
	
	
}
