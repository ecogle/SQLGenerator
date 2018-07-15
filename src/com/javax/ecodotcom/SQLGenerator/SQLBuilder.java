package com.javax.ecodotcom.SQLGenerator;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SQLBuilder {

	private String table;	
	private List<String> cols = new LinkedList<>();
	private char alias;
	private List<String> wheres = new LinkedList<>();
	private StringBuilder columns = new StringBuilder();
	private LinkedHashMap<String, String> commandsList = new LinkedHashMap<>();
	private List<ColumnNames> colNames = new LinkedList<>();
	
	private static int selectCounter =0;
	private static int columnsCounter = 0;
	private static int fromCounter = 0;
	private static int whereCounter = 0;

	private static Integer keyCounter = 0;
	
	public SQLBuilder select() {
		
		commandsList.put("SELECT", "SELECT ");
		selectCounter++;
		return this;
	}
	
	public SQLBuilder columns() {
		
		commandsList.put("COLUM", " * ");
		columnsCounter++;
		return this;
	}

	public SQLBuilder columns(String... strings) {

		if (strings != null) {
			for (int x = 0; x < strings.length; x++) {

				if (x != strings.length - 1) {
					columns.append(strings[x] + ", ");
				} else {
					columns.append(strings[x]);
				}
			}
		} else {
			columns.append(" * ");
		}

		commandsList.put("COLUMN", columns.toString());
		columnsCounter++;
		return this;
	}

	public SQLBuilder select(List<ColumnNames> cols) {

		if (!cols.isEmpty()) {

			for (ColumnNames col : cols) {
				colNames.add(col);
			}
		}

		return this;
	}

	public SQLBuilder from(String table) {

		this.table = table;

		commandsList.put("FROM", " FROM " + this.table);
		fromCounter++;
		return this;
	}

	public <S, T> SQLBuilder where(Condition<S, T> condition) {
		
		commandsList.put("WHERE", " WHERE " + condition.toString());	
		whereCounter++;
		return this;
	}

	public <S,T> SQLBuilder and(Condition<S,T> condition) {
		wheres.add(" AND ");
		commandsList.put("AND" + keyCounter++, LogicalOperators.AND.getValue() + condition.toString());
		
		return this;
	}

	public <S,T> SQLBuilder or(Condition<S,T> condition) {
		wheres.add(" OR ");
		commandsList.put("OR" + keyCounter++, LogicalOperators.OR.getValue());
		
		return this;
	}
	
	public SQLBuilder nestedSelect(SQLBuilder builder) throws SQLGenerationError {
		
		commandsList.put("NestedSQL"+keyCounter++, "("+builder.buildQuery()+ ")");
		return this;
	}

	public String buildQuery() throws SQLGenerationError {

		StringBuilder str = new StringBuilder();

		validate();
		for (Map.Entry<String, ?> d : commandsList.entrySet()) {
			str.append(d.getValue());
		}

		return str.toString();
	}

	public SQLBuilder openingParenthesis() {
		commandsList.put("OpenParen" + keyCounter,"(");
		keyCounter++;
		return this;
	}
	public SQLBuilder closingParenthesis() {
		commandsList.put("ClosParen" + keyCounter, ")");
		keyCounter++;
		return this;
	}
	
	public void validate() throws SQLGenerationError {
		
		if(selectCounter == 0) 
			throw new SQLGenerationError("There is no SELECT");
		
		if(selectCounter > 1) 
			throw new SQLGenerationError("You have too many SELECT statements");
		
		if(columnsCounter == 0)
			throw new SQLGenerationError("You have no COLUMNs to select");
		
		if(columnsCounter >1)
			throw new SQLGenerationError("You have too many COLUMN statements");
		
		if(fromCounter == 0)
			throw new SQLGenerationError("You don't have a FROM statement");
		
		if(fromCounter >1)
			throw new SQLGenerationError("You have too many FROM statments");
		
		if(whereCounter > 1)
			throw new SQLGenerationError("You have too many WHERE clauses");
		
	}

}
