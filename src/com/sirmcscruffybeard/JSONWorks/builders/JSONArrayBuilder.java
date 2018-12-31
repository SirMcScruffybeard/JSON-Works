package com.sirmcscruffybeard.JSONWorks.builders;

import java.util.List;

import com.sirmcscruffybeard.JSONWorks.parts.JSONMap;
import com.sirmcscruffybeard.JSONWorks.parts.Parts;



/********************************************************************
 * JSONArrayBuilder
 * 
 * Creates a JSON array

 * @author SirMcScruffyBeard
********************************************************************/
public class JSONArrayBuilder {

	private JSONMap map = new JSONMap();
	
	private String JSONArray = Parts.ARR_START.toString();
	
	public JSONArrayBuilder() {}
	
	/**************************************************************
	 * JSONArrayBuilder(ArrayList<Object> inArrayList)
	 * 
	 * @param ArrayList<Object> inArrayList. 
	 * 
	 * Sets the class ArrayList to the one being passed in
	**************************************************************/
	public JSONArrayBuilder(List<Object> inList) {

		map.blendList(inList);
	}

	/***************************************************************
	 * JSONArrayBuilder(Object inObject)
	 * 
	 * @param Object inObject
	 *
	 * Sets up and empty array list and adds the passed object to it
	****************************************************************/
	public JSONArrayBuilder(Object inObject) {

		this.add(inObject);
	}
	
	/*************************************************************************************
	 * JSONArrayBuilder(Object[] inArray)
	 * 
	 * @param Object[] inArray
	 * 
	 * Constructor
	 * 
	 * Sets up an array list and adds the passed array to it using the addArray() function
	**************************************************************************************/
	public JSONArrayBuilder(Object[] inArray) {

		map.blendArray(inArray);
	}
	
	public JSONArrayBuilder(String inString) {

		this.addString(inString);
	}
	
	public void addString(String inString) {
		
		this.map.putString( inString);
	}

	/**********************************************************************
	 * add(Object inObject)
	 * 
	 * @param Object inObject
	 * 
	 * Adds the passed object to the ArrayList
	**********************************************************************/
	public void add(Object inObject) {map.put(inObject);}

	public void addList(List<Object> inList) {
		
		map.blendList(inList);
	}
	
	public void addStrings(List<String> inStrings) {
		
		map.blendStringList(inStrings);
	}
	
	public void addArray(Object[] inArray) {
		
		map.blendArray(inArray);
	}
	
	public void addStrings(String[] inStrings) {
		
		map.blendStringArray(inStrings);
	}

	
	/**********************************************************************
	 * toString()
	 * 
	 * @return String JSONArray
	 * 
	 * Builds and returns a complete JSON array String
	**********************************************************************/
	@Override
	public String toString() {
		
		for(int i = 0; i < map.size() - 1; ++i) {
			
			this.JSONArray = this.JSONArray + map.get(map.getKey(i)) + Parts.COMMA + Parts.SPACE;
		}
		
		this.JSONArray = this.JSONArray + map.get(map.getKey(map.size() - 1)) + Parts.ARR_END;
				
		return this.JSONArray;
	}
}