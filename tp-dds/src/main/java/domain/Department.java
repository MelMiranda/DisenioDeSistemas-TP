package domain;

public class Department extends Address {

	private int floor;
	private String department;
	private String unit;
	
	public String getFullAddress(){
		return ("Department: " + department +  ". Floor: " + floor + " . Unit: " + unit); 
	}
}
