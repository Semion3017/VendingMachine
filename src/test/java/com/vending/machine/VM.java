package com.vending.machine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.vending.machine.VendingMachineImpl;


public class VM {

private static VendingMachine vm;
	
	@BeforeClass
	public static void setUp() {
		vm = VendingMachineFactory.createVendingMachine();
	}
	
	@org.junit.Test
	public void testBuyItem() {
		long price = vm.selectItemAndGetPrice(Item.COKE);
		assertEquals(Item.COKE.getPrice(), price);
		
		vm.insertCoin(Coin.QUARTER);
		
		Bucket<Item, List<Coin>> bucket = vm.collectItemAndChange();
		Item item = bucket.getFirst();
		List<Coin> change = bucket.getSecond();
		
		assertEquals(Item.COKE, item);
		assertTrue(!change.isEmpty());  

	}
	
	@Test(expected=NotSufficientChangeException.class) //?
	public void testBuyItemWithMorePrice() {
		long price = vm.selectItemAndGetPrice(Item.SODA);
		assertEquals(Item.SODA.getPrice(), price);
		
		vm.insertCoin(Coin.QUARTER);
		vm.insertCoin(Coin.QUARTER);
		
		
		
		Bucket<Item, List<Coin>>  bucket = vm.collectItemAndChange();
		Item item = bucket.getFirst();
		List<Coin> change = bucket.getSecond();
		
		assertEquals(Item.SODA, item);
		assertTrue(!change.isEmpty());
		
		assertEquals(50 - Item.SODA.getPrice(), getTotal(change));
	
	}
	
	@Test(expected=SoldOutException.class)
    public void testSoldOut(){
        for (int i = 0; i < 9; i++) {
        	vm.selectItemAndGetPrice(Item.COKE);
            vm.insertCoin(Coin.QUARTER);
            vm.collectItemAndChange();
        }
     
    }
	
	
	 @Test(expected=NotSufficientChangeException.class)
	    public void testNotSufficientChangeException(){
	        for (int i = 0; i < 9; i++) {
	            vm.selectItemAndGetPrice(Item.SODA);
	            vm.insertCoin(Coin.QUARTER);
	            vm.insertCoin(Coin.QUARTER);
	            vm.collectItemAndChange();
	           
	            vm.selectItemAndGetPrice(Item.PEPSI);
	            vm.insertCoin(Coin.QUARTER);
	            vm.insertCoin(Coin.QUARTER);
	            vm.collectItemAndChange();
	        }
	    }
	   
	   
	    @Test(expected=SoldOutException.class)
	    public void testReset(){
	        VendingMachine vmachine = VendingMachineFactory.createVendingMachine();
	        vmachine.reset();
	       
	        vmachine.selectItemAndGetPrice(Item.COKE);
	       
	    }
	    
	    
	    private long getTotal(List<Coin> change){
	        long total = 0;
	        for(Coin c : change){
	            total = total + c.getDenomination();
	        }
	        return total;
	    }
	

	
	
	@AfterClass
	public static void tearDown() {
		vm = null;
	}


}
