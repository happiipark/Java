class TempClass{  // 클래스 앞에 final 이 붙으면 상속 불가
	final int x = 10; // 객체들이 각각 다른값으로 생성자로 초기화
	
	static final int sx = 100; // 모든 객체들이 동일한 값 가질려면 static final
	
	TempClass(int x){
//		this.x = x; // 명시적 초기화를 먼저 진행 할 경우 생성자에서 진행되는 초기화는 불가능
//		sx = x; // static final은 생성자에서 초기화 할 수 없다.
	}
	void method(int x) {
//		this.x=x; // final 변수라 수정이 안됨 오류
	}
}

public class FinalTest1 {
	
	public static void main(String[] args) {
		final int n;
		n = 10; 
//		n = 20;  //final이라 처음 초기화 한 부분만 가능하고 두번째인 << 부분은 오류
		System.out.println(n);
		
		new TempClass(20);
		new TempClass(30);
		
	}

}
