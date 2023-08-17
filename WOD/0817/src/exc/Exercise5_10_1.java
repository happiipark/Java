package exc;

public class Exercise5_10_1 {

	public static void main(String[] args) {
		char[] abcCode = { '`', '~', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '+', '=', '|', '[',
				']', '{', '}', ';', ':', ',', '.', '/' };
		// 0 1 2 3 4 5 6 7 8 9
		char[] numCode = { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p' };
		String result = "`~!wer";
		String src = ""; // abc123 이 나와야 함

		for (int i = 0; i < result.length(); i++) {
			char ch = result.charAt(i);
			/*
			 * (1) 알맞은 코드를 넣어 완성하시오.
			 */
			if (ch >= 'a' && ch <= 'z') { // numCode
				// ch와 numCode 배열 안에 같은 값의 문자가 존재
				// 해당 문자의 인덱스 번호를 알아 낸 후 인덱스 번호 + '0'를 하면 아스키 코드의 숫자 값이 저장된다?
				
			} else { // abcCode

			}
		}
		System.out.println("result:" + result);
		System.out.println("src:" + src);

	}

}
