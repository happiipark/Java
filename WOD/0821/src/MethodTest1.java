

class MyMath {  // method 정의  
//	int add(int x, int y) { // 리턴 타입이 int
//		int result = x + y;
//		return result;
//	}
	
	static int add(int x, int y) {
		int result = x + y;
		return result;
	}
	static int multi(int x, int y) {
		int result = x * y;
		return result;
	}
	
	// 메서드에 리턴 타입이 없을 경우 void 라고 선언 해준다
	// void 타입 메서드는 메서드 중간에서도 return이 가능 그럴경우 return 아래 코드들은
	// 처리하지 않고 종료
	// 만약 return을 작성하지 않을경우 끝나는 괄호 ' } ' 를 만나야만 메서드가 종료!
}

public class MethodTest1 {
	public static void main(String[] args) {
//		MyMath mm = new MyMath();
//		int res = mm.add(10, 20); // method 호출
		int res = MyMath.add(10, 20); // method 호출
		// 호출 시점에 int x = 10, int y = 20; 으로 메서드에 들어감
		System.out.println(res);
		res = MyMath.multi(100, 200);
		System.out.println(res);
	}

}
