public class ArrayTest1 {
	public static void main(String[] args) {
		int[] narr1 = new int[5]; // 배열 선언과 동시에 초기화
		double[] darr1 = new double[5];
		
		int[] narr2; // 주소를 담을 그릇만 생성 // 배열 선언
		narr2 = new int[10]; // 배열 초기화
		
		narr1[0] = 1;
		narr1[1] = 2;
		narr1[2] = 3;
		narr1[3] = 4;
		narr1[4] = 5;
//		narr1[5] = 6;
		
		int sum = 0;
		for(int i = 0; i < narr1.length; i++) {
			sum += narr1[i];
		}
		System.out.println(sum);
	}

}
