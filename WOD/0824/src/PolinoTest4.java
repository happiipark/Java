class Car {
	String color;
	int door;
	void drive() {
		System.out.println("drive, Brrrr");
	}
	
	void stop() {
		System.out.println("stop!!");
	}
}

class FireEngine extends Car {
	void water() {
		System.out.println("Water!!!");
	}
}

class Amblunce extends Car {
	void siren() {
		System.out.println("siren~~~");
	}
}

public class PolinoTest4 {
	
	public static void main(String[] args) {
		FireEngine fe = new FireEngine();
		fe.water();
		
		Car car = fe; // upcasting -> car 가 fe의 주소인 new FireEngine(); 가리켜서 가능한게 아닌가?
//		car.water(); // car 에 water() 메소드가 없어서   FireEngine 클래스에는 존해하지만 결국 Car 클래스에 없기에 불가능!!
		if(car instanceof FireEngine) {
			FireEngine fe2 = (FireEngine)car; // downcasting
			fe2.water();
		}
		
		
	}

}
