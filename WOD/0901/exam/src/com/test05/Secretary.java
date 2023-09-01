package com.test05;

public class Secretary extends Employee implements Bonus{
	
	
	
	Secretary() {}
	Secretary(String name, int number, String deparment, int salary) {
		super(name, number, deparment, salary);
		
	}
	

	@Override
	double tax() {  // 세금
		return super.salary * 0.1;
	}

	@Override
	public void incentive(int pay) {  //인센티브 지급
		super.salary += (pay*0.8);
		
	}

}
