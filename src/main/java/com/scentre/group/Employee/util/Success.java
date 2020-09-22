package com.scentre.group.Employee.util;

public class Success {
	boolean isSuccessful;
	String message;
	String name;

	public Success(boolean isSuccessful, String message, String name) {
		super();
		this.isSuccessful = isSuccessful;
		this.message = message;
		this.name = name;
	}

	public boolean isSuccessful() {
		return isSuccessful;
	}

	public void setSuccessful(boolean isSuccessful) {
		this.isSuccessful = isSuccessful;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
