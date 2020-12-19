package com.ankita.app.RouletteConsole.enums;

public enum BetType {

	ODD("ODD"), EVEN("EVEN"), NUMBER("NUMBER");

	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	private BetType(String value) {
		this.value = value;
	}

	
	
	
}
