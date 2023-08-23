class Shape {
	
	String color;
	void draw() {
		System.out.println("shape");
	}
}

class Circle extends Shape {
	int x;
	int y;
	int r;
	
	@Override
	void draw() {
		System.out.println("circle");
	}
}

public class PolinoTest1 {
	
	public static void main(String[] args) {
		Circle c = new Circle();
		c.color = "green";
		c.r = 20;
		c.x = c.y = 10;
		c.draw();  
		
		
		
		Shape s = new Circle(); // upcasting : 자식 객체를 부모 레퍼런스에 넣는다
		s.color = "red";
//		s.x=10;
		s.draw();  // 다형성 : 상속, 업케스팅, 오버라이딩이 된 메서드는 자식 객체를 부모 타입의 변수로 호출시 자식의 메서드가 실행된다.
		
	}

}
