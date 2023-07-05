package com.vending.machine;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Item {
	
	COKE("Coke", 25), PEPSI("Pepsi", 35), SODA ("Soda", 45);
	
	private String name;
	private int price;
	
	

}
