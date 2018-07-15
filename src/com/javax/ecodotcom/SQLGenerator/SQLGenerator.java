package com.javax.ecodotcom.SQLGenerator;

public class SQLGenerator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SQLBuilder sql = new SQLBuilder();
		try {
			String query = sql.select().columns("n.fName", "n.lName", "n.ssn").from("names n")
					.where(new Condition<String, String>("n.fname", "\'Chad\'", ComparisonOperators.NOTEQUALTO))
					.and(new Condition<String, String>("n.lName", "\'Ogle\'", ComparisonOperators.EQUALTO))					
					.and(new Condition<String, Integer>("n.age", 45, ComparisonOperators.GREATERTHAN))					
					.buildQuery();
			System.out.println(query);
		} catch (SQLGenerationError e) {
			e.printStackTrace();
		}

	}

}
