package exc;

public class Ex9 {

	public static void main(String[] args) {
		String str = "12345";
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			sum += ch - '0';  // 특정 숫자 char을 실제 숫자로 변경하는 방법
			// -> sum += str.charAt(i) - '0';
		}
		System.out.println("sum=" + sum);
	}

}
