
public class ExceptionTest3 {
	public static void main(String[] args) {
		try{
			throw new Exception("예외 발생");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
