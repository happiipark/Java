
public class CastTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		byte bt = 10;
		int i = bt; // 자동 형 변환: 큰 범위에 작은 범위를 담을 수 있다
		
		byte bt2 = (byte)i; // 강제 형 변환 -> Casting 
		// 강제 형 변환 : 작은 범위의 변수를 큰 범위 변수에 넣어주기 위해 강제적으로 캐스팅 해줌
		
		float f = i; // float가 int와 같은 크기지만 실질적으로 더 크다
		int i2 = (int)f; // 소수점 잘림
		
		double d = f;
		float f2 = (float)d; // 개발자 판단아래 상관 없을경우 사용!
		
	}

}
