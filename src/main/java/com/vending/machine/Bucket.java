package com.vending.machine;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Bucket<T1, T2> {

	
	private T1 first;
	private T2 second;
}

