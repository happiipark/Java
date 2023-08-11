
public class Lotto2 {

	public static void main(String[] args) {
		int[] ball = new int[6];
		int cnt = 0;  // 뽑은 공의 개수 -> 전부 비교 하는 헛 수고 방지
		boolean same = false;

		while (true) {
			int rand = (int) (Math.random() * 45) + 1;
			// ball 배열에서 rand와 같은 값이 있는지 체크
			same = false;
			for (int i = 0; i < cnt; i++) {
				if (ball[i] == rand) {
					same = true;
					break;
				}
			}
			if (same == false) {
				ball[cnt++] = rand;
			}
			if (cnt == 6)
				break;
		}
		for (int i = 0; i < ball.length; i++) {
			System.out.print(ball[i] + ",");
		}

	}

}
