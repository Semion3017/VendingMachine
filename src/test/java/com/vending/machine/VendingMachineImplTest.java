package com.vending.machine;




import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;



public class VendingMachineImplTest {

	private static VendingMachine vm;
	
	@BeforeClass
	public static void setUp() {
		vm = VendingMachineFactory.createVendingMachine();
	}
	
	@Test
	private void testBuyItemWithExactPrice() {
		long price = vm.selectItemAndGetPrice(Item.COKE);
		assertEquals(Item.COKE.getPrice(), price);
		
		vm.insertCoin(Coin.QUARTER);
		
		Bucket<Item, List<Coin>> bucket = vm.collectItemAndChange();
		Item item = bucket.getFirst();
		List<Coin> change = bucket.getSecond();
		
		assertEquals(Item.COKE, item);
		assertTrue(change.isEmpty());
	}
	
	@Test
	private void t() {
		int x = 25;
		assertEquals(25, x);
	}
	
	
	@AfterClass
	public static void tearDown() {
		vm = null;
	}

}
