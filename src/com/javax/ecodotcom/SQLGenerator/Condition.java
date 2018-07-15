package com.javax.ecodotcom.SQLGenerator;

public class Condition<S,T> {

	public void setCondition1(String condition1) {
		this.condition1 = condition1;
	}

	public void setCondition2(T condition2) {
		this.condition2 = condition2;
	}

	private String condition1;
	private T condition2;
	private ComparisonOperators l;
	private char alias;
	
	
	public char getAlias() {
		return alias;
	}

	public void setAlias(char alias) {
		this.alias = alias;
	}

	public Condition(String cond1, T cond2, ComparisonOperators l) {
		this.condition1 = cond1;
		this.condition2 = cond2;
		this.l = l;
	}
	
	@Override
	public String toString() {
		
		
		return this.getCondition1() + " " + l.getValue() + " " + this.getCondition2();
		
	}

	public String getCondition1() {
		return condition1;
	}	

	public T getCondition2() {
		return condition2;
	}
	
	public void setAliasOnColumnName(char s) {
		
		StringBuilder p = new StringBuilder();
		
		this.condition1 = p.append(s + "." +this.condition1).toString();
		
		
	}

	
	
}
