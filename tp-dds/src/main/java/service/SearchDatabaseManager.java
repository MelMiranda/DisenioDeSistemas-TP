package service;

import java.util.ArrayList;
import java.util.List;

public class SearchDatabaseManager {
	
	List<String> allSearches= new ArrayList<String>();
	
	public void saveSearch(String search){
		allSearches.add(search);
	}

}
