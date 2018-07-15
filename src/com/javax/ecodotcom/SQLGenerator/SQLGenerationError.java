package com.javax.ecodotcom.SQLGenerator;

@SuppressWarnings("serial")
public class SQLGenerationError extends Exception {
	
	public SQLGenerationError(String s) {
		super(s);
		printStackTrace(System.out);
	}

}
