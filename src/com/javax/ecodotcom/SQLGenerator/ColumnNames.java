package com.javax.ecodotcom.SQLGenerator;

public class ColumnNames {

	
	private String colName;
	private String tableQualifier;
	public ColumnNames(String colName,String tableQualifier) {
		
		this.colName = colName;
		this.tableQualifier = tableQualifier;
	}
	public String getColName() {
		return colName;
	}
	public String getTableQualifier() {
		return tableQualifier;
	}

}
