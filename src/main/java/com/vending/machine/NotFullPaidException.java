package com.vending.machine;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NotFullPaidException extends RuntimeException {


	private static final long serialVersionUID = -1749196433298525166L;
 
	private String message;
	private long remaining;
	
	
	
	public long getRemaining() {
		return remaining;
	}
	
	public String getMessage() {
		return message + remaining;
	}
	
}
