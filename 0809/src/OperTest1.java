
public class OperTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 10;
		n++; // n = n + 1;
		System.out.println(n); // 11 출력
		++n; // n = n + 1;
		System.out.println(n); //12 출력
		
		int m = 100;
		int res = ++m; // 증가된 값을 연산의 결과로 반영
		System.out.println(res);
		res = m ++; // 증가되기 이전 값을 연산의 결과로 반영
		System.out.println(res);
		
	}

}
