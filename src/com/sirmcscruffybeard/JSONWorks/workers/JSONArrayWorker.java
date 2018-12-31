package com.sirmcscruffybeard.JSONWorks.workers;

public class JSONArrayWorker extends JSONWorker{

	public JSONArrayWorker() {
		// TODO Auto-generated constructor stub
	}
	
	public JSONArrayWorker(String JSONArray) {

		this.setArray(JSONArray);
	}
	
	public void setArray(String JSONArray) {
		
		super.setItem(JSONArray);
	}
}
