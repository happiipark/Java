class Parent {
	int n;
//	Parent() {
//		System.out.println("Parent()");
//	}
	
	Parent(int n) {
		this.n = n;
		System.out.println("Parent(int n)");
	}
}

class Child extends Parent {
	int m;
	Child() {
		super(0);  // 기본 생성자가 아닌 다른 생성자를 호출 할 때 super() 사용
		System.out.println("Child()");
	}
	
	Child(int n, int m) {  // n은 부모 클래스의 변수기 때문에 생성자를 통해 초기화?
		super(n);
		this.m=m;
	}
}

public class InheritTest3 {

	public static void main(String[] args) {
//		Parent p = new Parent();
		Child c = new Child(10,20);
	}
}
