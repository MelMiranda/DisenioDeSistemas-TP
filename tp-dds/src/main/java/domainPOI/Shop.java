package domainPOI;

public class Shop extends Comercial{
	
	
	private CategoryType category;
	
	
	
	
	public boolean isNearBy(Coordinate cordinate){
		return category.isNearBy(cordinate);

	}
	
	public boolean isEnable(){
		return true; //TO DO
	}
	
	

}
