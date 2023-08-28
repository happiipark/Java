package exc;

class NumberException extends RuntimeException {
	
}

class InvalidNumberException extends NumberException {
	
}

class NotAnumberException extends NumberException {
	
}
public class Ex8_4 {
	
	static void method() throws InvalidNumberException, NotAnumberException {}
	public static void main(String[] args) {
//		try {
//			method();
//		} catch(InvalidNumberException e) {
//			
//		} catch(NotAnumberException e) {}
		
//		try {
//			method();
//		} catch (NumberException e) {}
		
//		try {
//			method();
//		} catch(RuntimeException e) {}
		
//		try {
//			method();
//		} catch (Exception e) {}
		
		try {
			method();
		} catch (NumberException e) {
		} catch (Exception e) {}
		
//		try {
//			method();
//		} catch (Exception e) {
//		} catch (NumberException e) {} // error -> 부모 클래스의 예외 처리가 먼저 실행되어서 다 처리됨
		
	}
	

}
