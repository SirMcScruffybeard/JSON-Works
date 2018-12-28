package com.sirmcscruffybeard.JSON_works.object_handlers;

import java.util.ArrayList;

import com.sirmcscruffybeard.JSON_works.string_handlers.Parts;

/********************************************************************
 * ArrayBuilder
 * 
 * This class creates a JSON array
 * 
 * Stores the items in an Array List. Processes the Array List into 
 * a JSON Array
 * 
 * @author SirMcScruffyBeard
********************************************************************/
public class JSONArrayBuilder {

	private ArrayList<Object> arrayList = new ArrayList<>();
	
	private String JSONArray = Parts.ARR_START.toString();
	
	final String END = Parts.ARR_END.toString();
	
	final String COMMA = Parts.COMMA.toString();
			
	/***********************************************
	 * ArrayBuilder()
	 * 
	 * Constructor
	 * 
	 * Sets up a empty array list
	***********************************************/
	public JSONArrayBuilder() {

		
	}

	/**************************************************************
	 * ArrayBuilder(ArrayList<Object> inArrayList)
	 * 
	 * @param ArrayList<Object> inArrayList. 
	 * 
	 * Constructor
	 * 
	 * Sets the class Array List to the one being passed in
	**************************************************************/
	public JSONArrayBuilder(ArrayList<Object> inArrayList) {

		this.arrayList = inArrayList;
	}

	/***************************************************************
	 * ArrayBuilder(Object inObject)
	 * 
	 * @param Object inObject
	 * 
	 * Constructor
	 * 
	 * Sets up and empty array list and adds the passed object to it
	****************************************************************/
	public JSONArrayBuilder(Object inObject) {

		this.add(inObject);
	}
	
	/*************************************************************************************
	 * ArrayBuilder(Object[] inArray)
	 * 
	 * @param Object[] inArray
	 * 
	 * Constructor
	 * 
	 * Sets up an array list and adds the passed array to it using the addArray() function
	**************************************************************************************/
	public JSONArrayBuilder(Object[] inArray) {

		this.arrayList = this.arrayToArrayList(inArray);
	}

	/**********************************************************************
	 * add(Object inObject)
	 * 
	 * @param Object inObject
	 * 
	 * Adds the passed object to the ArrayList
	**********************************************************************/
	public void add(Object inObject) {arrayList.add(inObject);}

	/**********************************************************************
	 * arrayToArrayList(Object[] inArray)
	 * 
	 * @param Object[] inArray
	 * 
	 * @return ArrayList<Object>
	 * 
	 * Converts an array into an ArrayList<Object>
	**********************************************************************/
	public ArrayList<Object> arrayToArrayList(Object[] inArray) {
		
		ArrayList<Object> newAList= new ArrayList<>();
		
		for(int i = 0; i < inArray.length; i++ ) {

			newAList.add(inArray[i]);
		}
		
		return newAList;
	}

	/**********************************************************************
	 * getArrayList()
	 * 
	 * @return ArrayList<Object> arrayList
	**********************************************************************/
	public ArrayList<Object> getArrayList() {return this.arrayList;}
	
	/**********************************************************************
	 * toString()
	 * 
	 * @return String JSONArray
	 * 
	 * Builds and returns a complete JSON array String
	**********************************************************************/
	@Override
	public String toString() {
		
		for(int i = 0; i < arrayList.size() - 1; i++) {
			
			this.JSONArray = this.JSONArray + arrayList.get(i).toString() + COMMA;
		}
		
		this.JSONArray = this.JSONArray + arrayList.get(arrayList.size() - 1).toString();
		
		this.JSONArray = this.JSONArray + END;
		
		return this.JSONArray;
	}
}
