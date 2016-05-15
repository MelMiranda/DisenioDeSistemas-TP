package externalServices;

import java.util.List;

public class CentroDTO {

	private int numberCGP;
	private String zones;
	private String directorName;
	private String address;
	private String telephone;
	private List<ServicioDTO> cgpServices;
	
	public int getNumberCGP() {
		return numberCGP;
	}
	public void setNumberCGP(int numberCGP) {
		this.numberCGP = numberCGP;
	}
	public String getZones() {
		return zones;
	}
	public void setZones(String zones) {
		this.zones = zones;
	}
	public String getDirectorName() {
		return directorName;
	}
	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public List<ServicioDTO> getCgpServices() {
		return cgpServices;
	}
	public void setCgpServices(List<ServicioDTO> cgpServices) {
		this.cgpServices = cgpServices;
	} 








}
