class Base {
	int x=1;

	void method() {
		System.out.println("Base method");
	}
}

class Derived extends Base {
	int x=2;
	int y=3;

	void method() { // overriding
		System.out.println("Derived method");
	}
}

public class PolinoTest3 {
	public static void main(String[] args) {
		Base base1 = new Derived(); // upcasting -> 메서드는 오버라이딩 가능해도 변수는 오버라이딩 X
		base1.method(); // 다형성, Derived 클래스의 method()가 호출
		// Base 형태의 변수 base 생성 -> 스택 메모리 공간에 저장됨
		// base 가 힙 메모리 공간에 저장된 Derived를 컨트롤 할 수 있음
		base1.x = 10;
//		base1.y=20;  

		Base base2 = new Base();
		base2.method(); // Base 클래스의 method() 호출

//		Derived derived1 = (Derived) base1; // downcasting
//		derived1.y = 20;
//		Derived derived2 = (Derived) base2;
//		derived2.y = 30;

		if (base1 instanceof Derived) { // Derived에 의해 생성된거 인지 확인? : true
			Derived derived1 = (Derived) base1; // downcasting
			derived1.y = 20;
		}
		if (base2 instanceof Derived) { // Derived에 의해 생성된거 인지 확인? : false
			Derived derived2 = (Derived) base2;
			derived2.y = 30;
		}
		
		Base base3 = new Derived();
		base3.method(); // Derived method 호출
		System.out.println(base3.x);  // Base의 X 값 출력
		
	}

}
