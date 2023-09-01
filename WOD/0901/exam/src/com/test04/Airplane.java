package com.test04;

public class Airplane extends Plane {
	
	Airplane(){}
	
	Airplane(String name, int fuelSize){
		super(name,fuelSize);
	}

	@Override
	void flight(int distance) {  // 운항
		this.fuelSize -= distance * 3;
		
	}

}
