
public class Exercise4_12 {
	public static void main(String[] args) {

		// 부끄러운 내가 푼 풀이
//        // 구구단 질문!!
//		for (int i = 1; i <= 3; i++) {
//			for (int j = 2; j <= 4; j++) {
//				System.out.print(String.format("%d X %d = %2d\t", j, i, j * i));
//			}
//			System.out.println();
//		}
//		System.out.println();
//		for (int i = 1; i <= 3; i++) {
//			for (int j = 5; j <= 7; j++) {
//				System.out.print(String.format("%d X %d = %2d\t", j, i, j * i));
//			}
//			System.out.println();
//		}
//		System.out.println();
//		for (int i = 1; i <= 3; i++) {
//			for (int j = 8; j <= 9; j++) {
//				System.out.print(String.format("%d X %d = %2d\t", j, i, j * i));
//			}
//			System.out.println();
//		}

		// 강사님 풀이
		for (int i = 0, dan = 2; i < 3; i++, dan += 3) {
			for (int j = 1; j <= 3; j++) {
				for (int k = dan; k <= ((dan + 2 < 10) ? dan + 2 : 9); k++) {
					System.out.print(String.format("%d X %d = %2d\t", k, j, k * j));
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}
