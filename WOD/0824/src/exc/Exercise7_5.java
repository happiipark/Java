package exc;

//class Product {
//	int price; // 제품의 가격
//	int bonusPoint; // 제품구매 시 제공하는 보너스점수
//
////	Product() {} // 정답  1 : 부모 클래스의 기본 클래스가 없어서 자식 클래스에서 오류가 발생
//	
//	Product(int price) {
//		this.price = price;
//		bonusPoint = (int) (price / 10.0);
//	}
//}
//
//class Tv extends Product {
//	Tv() { // 자식 클래스에서 부모의 기본 생성자가 없으면 에러가 발생한다
////		super(0); // 정답 2 : 자식 클래스의 기본 생성자에서 부모 클래스의 생성자로 바로 가게끔 해준다
//	}
//
//	public String toString() {
//		return "Tv";
//	}
//}

class Exercise7_5 {
	public static void main(String[] args) {
		Tv t = new Tv();
	}
}