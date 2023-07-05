package com.vending.machine;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SoldOutException extends RuntimeException{

	private static final long serialVersionUID = 2097220390975432791L;
	
	private String message;
	
	@Override
	public String getMessage() {
		return message;
	}
}
