
public class ContinueTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		// 1 for문
//		for(int i = 1; i<=100; i++) {
//			if(i % 2 == 0) {
//				sum += i;
//			}
//		}
		// 2. continue 사용
		for(int i =1 ; i <= 100; i++) {
			if(i % 2 != 0) {
				continue;
			}
			sum += i;
		}
		System.out.println(sum);
	}

}
