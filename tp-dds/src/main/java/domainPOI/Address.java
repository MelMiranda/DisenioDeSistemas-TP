package domainPOI;

import java.util.List;

public class Address {

	
	private String mainStreet;
	private int number;
	private List<String> betweenStreet;
	private Town town;
	
	public String getAddress(){
	return ("Address: " + mainStreet+ " " + number + " .Between streets " + betweenStreet.get(0) + " and " + betweenStreet.get(1)+ "." );
	}
	
	public String getFullAddress(){
		return (getAddress() + town.getFullAddress());
	}
}
