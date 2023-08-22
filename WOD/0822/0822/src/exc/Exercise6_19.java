package exc;

public class Exercise6_19 {
	// 다음 코드의 실행 결과를 예측하여 적으시오.
	public static void change(String str) {
		str += "456";
	}

	public static void main(String[] args) {
		String str = "ABC123";
		String str1 = "ABC123";
		System.out.println(str==str1);  // ==는 주소를 비교
		// 지금은 true가 나오지만 상황에 따라서 false가 나올 수 도 있다
		
		String str2 = new String("ABC123"); 
		String str3 = new String("ABC123");
		System.out.println(str2==str3); // false 
		
		System.out.println(str);
		change(str);
		System.out.println("After change:" + str);
	}
}
