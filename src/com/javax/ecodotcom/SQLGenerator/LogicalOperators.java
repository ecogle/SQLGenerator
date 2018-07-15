package com.javax.ecodotcom.SQLGenerator;

public enum LogicalOperators {
	
	AND(" AND "),
	NOT(" NOT "),
	OR(" OR ");
	
	private final String value;
	
	private LogicalOperators(String val) {
		// TODO Auto-generated constructor stub
		this.value = val;
	}

	public String getValue() {
		return value;
	}

}
