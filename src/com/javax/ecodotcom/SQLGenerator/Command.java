package com.javax.ecodotcom.SQLGenerator;

public class Command {
	
	private String src;
	private String command;
	
	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public Command(String src, String com) {
		this.src = src;
		this.command = com;
	}
}
