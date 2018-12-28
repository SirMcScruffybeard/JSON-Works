package com.sirmcscruffybeard.JSON_works;

import java.util.LinkedHashMap;

public class Test {


	public static void main(String[] args) {

		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		
		String s = "";
		
		for(int i = 0; i <= 10; i++) {

			map.put(String.valueOf(i), String.valueOf(i));
		}	
		
		String[] keys = new String[map.keySet().size()];
		
		map.keySet().toArray(keys);
		
		for(int i = 0; i <= 10; i++) {
			
			s += keys[i] + ":" + map.get(keys[i]) + ", ";
		}
		
		System.out.print(s);
	}
}
