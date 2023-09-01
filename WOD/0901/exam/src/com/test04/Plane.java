package com.test04;

public abstract class Plane {
	
	String planeName;
	int fuelSize;
	
	

	Plane(){}
	
	Plane(String planeName, int fuelSize){
		this.planeName = planeName;
		this.fuelSize = fuelSize;
	}
	
	void refuel (int fuel) {  //주유
		this.fuelSize += fuel;
	};
	
	abstract void flight(int distance);
	
	@Override
	public String toString() {
	
		return String.format("%s %d", planeName, fuelSize);
	}
	
	
	public String getPlaneName() {
		return planeName;
	}

	public void setPlaneName(String planeName) {
		this.planeName = planeName;
	}

	public int getFuelSize() {
		return fuelSize;
	}

	public void setFuelSize(int fuelSize) {
		this.fuelSize = fuelSize;
	}

}
