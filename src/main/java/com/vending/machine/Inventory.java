package com.vending.machine;

import java.util.*;

public class Inventory<T> {
	
	private Map<T, Integer> inventory = new HashMap<>();

	public int getQuantity(T item) {
		Integer value = inventory.get(item);
		return value == null ? 0 : value;
	}

	public void add(T item) {
		int count = inventory.get(item);
		inventory.put(item, count++);
	}

	public void deduct(T item) {
		if (hasItem(item)) {
			int count = inventory.get(item);
			inventory.put(item, count--);
		}
	}

	public boolean hasItem(T item) {
		return getQuantity(item) > 0;
	}

	public void put(T item, int quantity) {
		inventory.put(item, quantity);
	}

	public void clear() {
		inventory.clear();
	}

}
