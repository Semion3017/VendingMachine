package com.vending.machine;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class NotSufficientChangeException extends RuntimeException {

	private static final long serialVersionUID = 2765429434228597755L;
	
	private String message;
	
	public String getMessage() {
		return message;
	}
}
