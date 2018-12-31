package com.sirmcscruffybeard.JSONWorks.builders;

import java.util.Map;

import com.sirmcscruffybeard.JSONWorks.parts.JSONMap;
import com.sirmcscruffybeard.JSONWorks.parts.Parts;

public class JSONObjectBuilder {

	private JSONMap map = new JSONMap();

	private String JSONObject = Parts.OBJ_START.toString() + Parts.LINE;

	
	public JSONObjectBuilder() {}
	
	/*********************************************************************************************
	 * JSONObjectBuilder()
	 * 
	 * @param Map<String, String> inMap
	 * 
	 * Sets up a map that will be the base for the JSON object based on the passed map.
	 *********************************************************************************************/
	public JSONObjectBuilder(Map<String, String> inMap) {

		this.map = (JSONMap) inMap;
	}


	/*********************************************************************************************
	 * JSONObjectBuilder()
	 * 
	 * @param String inKey
	 * 
	 * @param String inString
	 * 
	 * Sets up a map that will be the base for the JSON object with a single string
	 *********************************************************************************************/
	public JSONObjectBuilder(String inKey, String inString) {

		this.putString(inKey, inString);

	}

	/*********************************************************************************************
	 * getMap()
	 * 
	 * @return Map<String, String> 
	 * 
	*********************************************************************************************/
	public Map<String, String> getMap() {return map;}

	public void putString(String inKey, String inString) {
		
		map.putString(inKey, inString);
		
	}
	
	public void put(String inKey, Object inObject) {
		
		map.put(inKey, inObject);
	}
		
	private String prepBodyLine(String key, String value) {

		return Parts.INDENT + this.prepLine(key, value) + Parts.COMMA + Parts.LINE + Parts.LINE;
	}

	private String prepKey(String key) {
		
		return Parts.QUOTES + key + Parts.QUOTES;
	}

	private String prepLine(String key, String value) {
		
		return  this.prepKey(key) + Parts.COLON + Parts.SPACE + value;
	}
	
	private String prepEnd(String key, String value) {
		
		return Parts.INDENT + this.prepLine(key, value) + Parts.LINE + Parts.OBJ_END;
	}
	
	/*********************************************************************************************
	 * toString()
	 * 
	 * @return String that represents a JSON object
	*********************************************************************************************/
	@Override
	public String toString() {

		for (int i = 0; i < map.size() - 1; i++) {

			JSONObject += this.prepBodyLine(map.getKey(i), map.get(map.getKey(i)));
		}
		
		JSONObject += this.prepEnd(map.getKey(map.size()-1), map.get(map.getKey(map.size()-1)));

		return this.JSONObject;
	}
}
