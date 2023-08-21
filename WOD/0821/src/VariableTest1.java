

class MyClass {  // main 클래스에서 객체 생성 할 경우 MyClass 안에 변수 메서드 생성됨
	int num;
	static int snum;
	
	void setNum(int n) {
		
	}
}

public class VariableTest1 {
	
	public static void main(String[] args) {
		int n;
		MyClass mc = new MyClass(); // num 변수 생성
		
//		System.out.println(c); // 초기화 하지 않고 사용시 에러
		System.out.println(mc.num); // 초기화 하지 않고 사용 가능
		// -> 객체 생성시 초기화를 진행하기 때문에
		
		// 메모리 종류 heap, static
		// java 에서 메모리 관리는 Garbage Collection(가비지 컬렉션)가 관리 => 대상 메모리 heap
		// 메모리 영역 3가지 [ 프로그램 코드 영역(프로세스)
		//              , stack 영역 {데이터 영역(정적(static) 변수 ~= 전역 변수?, 지역 변수 ~= 함수 안에서 선언되는 변수)}
		//              , heap 영역 (new에 의해 생성되는 변수, 동적(dynamic) 메모리 생성)]
	}

}
