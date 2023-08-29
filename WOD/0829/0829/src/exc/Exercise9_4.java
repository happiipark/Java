package exc;

class Exercise9_4 {
	static void printGraph(int[] dataArr, char ch) {
		/*
		 * (1) printGraph메서드를 작성하시오.
		 */

		// 내가 푼거
//		for (int i = 0; i < dataArr.length; i++) {
//			for (int j = 0; j < dataArr[i]; j++) {
//				System.out.print(ch);
//				if (j  == dataArr[i] - 1) {
//					System.out.println(dataArr[i]);
//				}
//			}
//			System.out.println();
//		}
		
		// 강사님이 푼거
		for(int n : dataArr) {
			for(int i = 0; i<n; i++) {
				System.out.print(ch);
			}
			System.out.println(n);
		}
	}

	public static void main(String[] args) {
		printGraph(new int[] { 3, 7, 1, 4 }, '*');
	}
}
