package com.vending.machine;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Coin {
	
	PENNY(1), NICKLE(5), DIME(10), QUARTER(25);
	
	private int denomination;

}
