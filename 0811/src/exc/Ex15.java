package exc;

public class Ex15 {

	public static void main(String[] args) {
		// 감도 안 옴 질문!!
		// Hint : 나머지 연산자 사용
		// (((1 * 10)+2)*10+3)*10+2)*10+1
		
		// result = 1 : 1
		// result = 1 * 10 + 2 : 12
		// result = (1 * 10 + 2) * 10 + 3 : 123
		// result = ((1 * 10 + 2) * 10 + 3) * 10 + 2 : 1232
		// result = (((1 * 10 + 2) * 10 + 3) * 10 + 2) * 10 + 1 : 12321
		
		int number = 12321;
		int tmp = number;
		int result = 0; // 변수 number를 거꾸로 변환해서 담을 변수
		int sq = 0;
		while (tmp != 0) {
			result = result * 10 + tmp%10; 
			tmp /= 10; 
			sq++;
		}
		System.out.println(result);
		if (number == result)
			System.out.println(number + "는 회문수 입니다.");
		else
			System.out.println(number + "는 회문수가 아닙니다.");
	}
}
