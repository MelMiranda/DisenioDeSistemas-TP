

public class Prueba2 {

	
	public static void main(String[] args) {
		parseCiudadDtoJson parse=new parseCiudadDtoJson();
		CiudadesDto c=parse.parseJson();
		
	   System.out.println(c.getCiudades().get(0).getLimitPoints().get(0));

	}
	
	
	
}
