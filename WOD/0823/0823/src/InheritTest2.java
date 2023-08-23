class Base {
	int bnum;

	void method1() {} //1
	void method2() {} //2	
}

class Derived extends Base {
	int dnum;
	void method1(int n) {} // 5
	void method2() {
		method1(); // 가능, 1 호출
		super.method2(); // 2 호출
		method2(); // 잘못 사용 확률 매우 높음
	} // 6
	void method2(int n) {
		method2(); // 가능 6 호출
	} //3
	void method3() {} //4
}

public class InheritTest2 {
	public static void main(String[] args) {
		Base b = new Base();
		b.bnum = 10;
		b.method1(); //1
		b.method2(); //2
		
		
		Derived d = new Derived();
		d.bnum = 20;
		d.dnum = 30;
		d.method1(); // 1
		d.method2(); // 6 
		d.method3(); // 4
	}

}
