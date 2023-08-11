
public class VariableTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char ch = 'A';// char : 변수 타입 ,ch : 변수명 , = : 대입 연산자 ,'A' : 리터럴 데이터(초기 데이터)
		char up7;
		up7 = '7';
		ch = 'b';
		// eclipse : syso + Crtl + Space -> System.out.println();
		// intellij : sout + Crtl + Space -> System.out.println();
		System.out.println(ch);
		byte bt = 127; // -128 ~ 127 01111111 : 127, 11111111 : -128
		// 1byte = 8 bit
		// 1 bit 가 나타낼 수 있는 가지 수는 2^1개
		// 8 bit -> 2^8 개 : 256 -> -128 ~ 127
		int i = 10;
		float f = 1.25f;
		double d = 3.14;
		boolean b = false;
		// 소문자로 선언된 변수들은 기본 자료형
		String name = "stiven"; // String 문자열 변수
		final double pi = 3.14; // final 로 한번 선언된 변수는 변경이 불가능! 상수
//		pi = 3.141;
		
		
	}

}
