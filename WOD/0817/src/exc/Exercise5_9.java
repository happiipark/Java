package exc;

public class Exercise5_9 {
	public static void main(String[] args) {
		char[][] star = { 
				{ '*', '*', ' ', ' ', ' ' }, 
				{ '*', '*', ' ', ' ', ' ' }, 
				{ '*', '*', '*', '*', '*' },
				{ '*', '*', '*', '*', '*' } 
				}; // 4 X 5 행열
		char[][] result = new char[star[0].length][star.length];  //5 X 4 행열
		for (int i = 0; i < star.length; i++) {
			for (int j = 0; j < star[i].length; j++) {
				System.out.print(star[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		for (int i = 0; i < star.length; i++) {
			for (int j = 0; j < star[i].length; j++) {
				/*
				 * (1) 알맞은 코드를 넣어 완성하시오.
				 */
				result[j][star.length-1-i] = star[i][j];
			}
		}
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j]);
			}
			System.out.println();
		}

	}

}
