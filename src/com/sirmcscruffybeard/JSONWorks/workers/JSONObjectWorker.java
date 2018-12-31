package com.sirmcscruffybeard.JSONWorks.workers;

public class JSONObjectWorker extends JSONWorker{

	public JSONObjectWorker() {
		// TODO Auto-generated constructor stub
	}
	
	public JSONObjectWorker(String JSONObject) {
		
		this.setObject(JSONObject);
	}
	
	public void setObject(String JSONObject) {
		
		super.setItem(JSONObject);
	}
	
}
