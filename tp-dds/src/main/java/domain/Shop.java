package domain;

public class Shop extends Poi{
	
	
	private CategoryType category;
	
	
	
	
	public boolean isNearby(Cordinate cordinate,Poi unPoi){
		
		
		return category.isNearby(cordinate, unPoi);

	}
	

}
