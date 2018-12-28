package com.sirmcscruffybeard.JSON_works.object_handlers;

import java.util.LinkedHashMap;
import java.util.Map;

import com.sirmcscruffybeard.JSON_works.string_handlers.Parts;

public class JSONObjectBuilder {

	private LinkedHashMap<String, String> map = null;

	private String JSONObject = Parts.OBJ_START.toString();
	
	final String COLON = Parts.COLON.toString();

	final String COMMA = Parts.COLON.toString();

	final String LINE = "/n";

	public JSONObjectBuilder() {

		setNewMap();
	}

	public JSONObjectBuilder(Map<String, String> inMap) {

		this.map = (LinkedHashMap<String, String>) inMap;
	}

	public JSONObjectBuilder(String inKey, Object inObject) {

		setNewMap();

		this.put(inKey, inObject);

	}

	private void setNewMap() {map = new LinkedHashMap<String, String>(); }

	public void put(String inKey, Object inObject) {map.put(inKey, inObject.toString());}

	public Map<String, String> getObject() {return map;}

	private String prepLine(String key, String value) {

		return key + COLON + value + COMMA + LINE;
	}

	
	
	@Override
	public String toString() {

		String[] keys = new String[map.size()];

		keys = map.keySet().toArray(keys);

		for (int i = 0; i < map.size() - 1; i++) {

			JSONObject += this.prepLine(keys[i], map.get(keys[i]));
		}

		JSONObject += keys[map.size()-1] + COLON + map.get(keys[map.size()-1]) + Parts.OBJ_END.toString();

		return this.JSONObject;
	}
}
