package com.test04;

public class Cargoplane extends Plane {
	

	
	
	Cargoplane(){}
	
	Cargoplane(String name, int fuelSize){
		super(name,fuelSize);
	}

	@Override
	void flight(int distance) {
		this.fuelSize -= distance * 5;

	}

}
