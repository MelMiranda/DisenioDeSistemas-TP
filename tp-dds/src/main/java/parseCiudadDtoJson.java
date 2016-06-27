import java.io.InputStream;
import java.io.InputStreamReader;


import com.fasterxml.jackson.core.type.TypeReference;


import json.JsonFactory;

public class parseCiudadDtoJson {
	private JsonFactory jsonFactory=new JsonFactory();
	
	
	
	public CiudadesDto  parseJson(){
		
		
		InputStream inputStream = Prueba2.class.getResourceAsStream("/ciudadesJson.json");
		
		CiudadesDto ciudadDto=this.jsonFactory.fromJson(new InputStreamReader(inputStream), new TypeReference<CiudadesDto>() {
		});		
		
		
		
	
		return ciudadDto;
		
		
	}



	public parseCiudadDtoJson() {
		super();
	}
}
