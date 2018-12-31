/**********************************************************************************
 * JSONMap
 * 
 * A Linked Hash Map that holds JSON items
 * 
 * @author SirMcScruffyBeard
 **********************************************************************************/

package com.sirmcscruffybeard.JSONWorks.parts;

import java.util.LinkedHashMap;
import java.util.List;

@SuppressWarnings("serial")
public class JSONMap extends LinkedHashMap<String, String> {

	/**********************************************************************************
	 * put
	 * 
	 * @param Object object
	 * 
	 * Puts the passed object into the map and generates a key
	 **********************************************************************************/
	public void put(Object object) {
		
		this.put(this.fixKey(""), String.valueOf(object));
	}
	
	public void put(String inKey, Object inObject) {
		
		super.put(inKey, String.valueOf(inObject));
	}
	
	/**********************************************************************************
	 * putString()
	 * 
	 * @param String key
	 * 
	 * @param String inString 
	 * 
	 * Formats inString for JSON use and puts it in the map at location key
	 **********************************************************************************/
	public void putString(String key, String inString) {

		this.put(key, this.formatString(inString));
	}
	
	/**********************************************************************************
	 * putString()
	 * 
	 * @param String inString 
	 * 
	 * Formats inString for JSON use and puts it in the map at a generated key
	 **********************************************************************************/
	public void putString(String inString) {
		
		this.putString(this.fixKey(""), inString);
	}

	private String formatString(String inString) {

		return Parts.QUOTES + inString + Parts.QUOTES;
	}

	public void blendArray(Object[] array) {

		for (int i = 0; i < array.length; i++) {

			this.put(this.fixKey(i), String.valueOf(array[i]));
		}

	}
	
	public void blendList(List<Object> list) {
		
		for (int i = 0; i < list.size(); i++) {
			
			this.put(this.fixKey(i), String.valueOf(list.get(i)));

		}
	}

	public void blendStringArray(String[] strings) {

		for (int i = 0; i < strings.length; i++) {

			strings[i] = this.formatString(strings[i]);
		}

		this.blendArray(strings);
	}
	
	public void blendStringList(List<String> strings) {
		
		for(int i = 0; i < strings.size(); i++) {
			
			strings.set(i, this.formatString(strings.get(i)));
			
			
		}
	}
	
	public String[] getKeys() {
		
		String[] keys = new String[this.size()];

		keys = this.keySet().toArray(keys);
		
		return keys;
	}
	
	public String getKey(int index) {
		
		return this.getKeys()[index];
	}
	
	private String fixKey(Object inKey) {

		String key = String.valueOf(inKey);

		int seed = 0;

		while(this.containsKey(key)) {

			key = String.valueOf(seed);

			seed++;
		}

		return key;
	}
	
}
