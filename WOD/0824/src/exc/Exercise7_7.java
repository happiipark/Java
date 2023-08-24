package exc;

//class Parent {
//	int x = 100;
//
//	Parent() {
//		this(200);
//	}
//
//	Parent(int x) {
//		this.x = x;
//	}
//
//	int getX() {
//		return x;
//	}
//}
//
//class Child extends Parent {
//	int x = 3000;
//
//	Child() {
//		// 부모 클래스의 기본 생성자 호출 생략 되어 있다고 생각해라
//		//super(); 
//		this(1000);
//	}
//
//	Child(int x) {
//		this.x = x;
//	}
//}

class Exercise7_7 {
	public static void main(String[] args) {
		Child c = new Child();
//		System.out.println("x=" + c.getX());
	}
}

// 실행 결과 :
