
public class Lotto {

	public static void main(String[] args) {
		// int 타입 45개 배열 선언 : ball
		int[] ball = new int[45];
		// ball 배열에 1~45까지 값으로 초기화
		for (int i = 0; i < ball.length; i++) {
			ball[i] = i + 1;
//			System.out.println(ball[i]);
		}
		// 0~44 중 하나의 임의의 정수 구해서 변수에 담기 - 변수명 : idx1
		// 0~44 중 하나의 임의의 정수 구해서 변수에 담기 - 변수명 : idx2
		// 0<= (int)(Math.random()*45) < 45

		for (int i = 0; i < 1000; i++) {
			int idx1 = (int) (Math.random() * 45);
			int idx2 = (int) (Math.random() * 45);

			int temp = ball[idx1];
			ball[idx1] = ball[idx2];
			ball[idx2] = temp;
		}

		for (int i = 0; i < 6; i++) {
			System.out.print(ball[i] + ",");
		}

	}

}
