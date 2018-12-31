package com.sirmcscruffybeard.JSON_works.parts;

public enum Parts {

	OBJ_START("{"), OBJ_END("}"), ARR_START("["), ARR_END("]"), COLON(":"), COMMA(","), 
	QUOTES("\""), INDENT("    "), LINE ("\n"), SPACE(" ");
	
	String part = "";
	
	Parts(String inString) {this.part = inString;}
	
	@Override
	public String toString()	 {return part;}
}
