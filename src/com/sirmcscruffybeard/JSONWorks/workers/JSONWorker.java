package com.sirmcscruffybeard.JSONWorks.workers;

public class JSONWorker {

	protected String item = "";

	protected char[] string;

	public JSONWorker() {
		// TODO Auto-generated constructor stub
	}

	public JSONWorker(String inItem) {

		this.setItem(inItem);
	}

	public void setItem(String inItem) {

		this.item = inItem;

		this.string = inItem.toCharArray();
	}

	public boolean isValid(String inItem, String start, String end) {

		return this.isValid(inItem.toCharArray(), start, end);
	}

	public boolean isValid(char[] inChars, String start, String end) {

		return String.valueOf(inChars[0]).equals(start) && String.valueOf(inChars[inChars.length-1]).equals(end);
	}
}
