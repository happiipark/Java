
public class ExceptionTest1 {

	public static void main(String[] args) {
		String str = "hong";
		int[] arr = new int[5];
//		String str = " ";
		// null != " " 은 다르다
		// null로 할 경우 주소가 없는것이고 "" 은 주소는 있다
		try {
			System.out.println(str.toString());
			for(int i = 0; i <= arr.length; i++) {
				arr[i] = 1*10;
			}
		}catch(NullPointerException e) {
//			System.out.println("null 입니다.");
			System.out.println(e.getMessage());
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("종료");
	}
}
