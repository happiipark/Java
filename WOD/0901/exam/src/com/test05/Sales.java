package com.test05;

public class Sales extends Employee implements Bonus {
	
	
	
	
	Sales() {}
	
	
	Sales(String name, int number, String deparment, int salary) {
		super(name, number, deparment, salary);
		
	}

	@Override
	double tax() {  // 세금
		return super.salary * 0.13;
	}

	@Override
	public void incentive(int pay) {  // 인센티브
		super.salary += (pay*1.2);
	}

}
