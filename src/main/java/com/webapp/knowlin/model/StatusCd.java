package com.webapp.knowlin.model;

public enum StatusCd {
	ACTIVE("A"),
	INACTIVE("I"),
	PENDING("P"),
	SUSPENDED("S");
	
	private String code;
	
	StatusCd(final String code) {
		this.code = code;
	}
	
	@Override
	public final String toString() {
		return this.code;
	}
	
	public static final StatusCd convertFrom(final String value) {
	
		for(StatusCd statCd : values()) {
			if(statCd.toString().equals(value)){
				return statCd;
			}
		}
		
		return null;
	}
}
