package com.test06.entity;

public class Coffee extends Drink{
	
	int COFFEE_PRICE = 100;
	
	
	Coffee(){}
	
	Coffee(int COFFEE_PRICE){
		super(COFFEE_PRICE);
	}
	
	@Override
	public String toString() {
		return super.toString();
	}

}
