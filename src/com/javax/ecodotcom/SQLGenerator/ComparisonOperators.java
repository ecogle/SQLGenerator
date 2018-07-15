package com.javax.ecodotcom.SQLGenerator;

public enum ComparisonOperators {

	GREATERTHAN(" > "),
	LESSTHAN(" < "),
	EQUALTO(" = "),
	NOTEQUALTO(" != ");
	
	private final String value;
	
	public String getValue() {
		return value;
	}

	ComparisonOperators(String val) {
		this.value = val;
	}
	
	
}
