
public class ContinueTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1-100 까지 합 중 4의 배수이거나 7의 배수면 스킵하고 더하기
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 4 == 0 || i % 7 == 0) {
				continue;
			}
			sum += i;
		}
		System.out.println(sum);
	}

}
