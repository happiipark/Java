
public class ExceptionTest4 {
	
	public static void method1() throws Exception{
		String str = null;
		try {
		System.out.println(str.toString());
		} catch (NullPointerException e) {
			System.out.println("method1에서 처리");
			throw new Exception("예외 다시 생성");
			// 런타임 exception이 아닌 예외를 발생 시킬 경우에는
			// throws Exception을 해줘야 한다 어디에? 메소드 선언부에!
		}
	}
	public static void main(String[] args) {
		try {
			method1();
		} catch(Exception e) {
			System.out.println("main에서 처리");
		}
		System.out.println("main 나머지 처리");
	}
}


// 꼭 에러가 난 메소드에서 예외처리를 안 해도 된다
// 메소드를 호출한 부분에서 처리 가능하다.
// 