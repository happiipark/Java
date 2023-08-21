

import java.util.Scanner;

public class TotTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sel = 0;
		int money = 0;
		int[] coins = { 5000, 1000, 500 };
		int[] price = { 1500, 2500, 2500, 2000, 3000 };

		while (true) {
			System.out.println("[코스타 카페]");
			System.out.println("1. 아메리카노(1500원)");
			System.out.println("2. 카페라떼(2500원)");
			System.out.println("3. 카푸치노(2500원)");
			System.out.println("4. 에스프레소(2000원)");
			System.out.println("5. 카페모카(3000원)");
			System.out.println("0. 종료");
			System.out.print("메뉴를 선택하세요>  ");

			sel = sc.nextInt();
			if (sel == 0)
				break;
			else if (sel < 0 || sel > 5)
				System.out.println("0~5사이의 번호를 입력해 주세요.");
			else {

				System.out.print("돈을 넣으세요>");
				money = sc.nextInt();
				if (money < price[sel - 1]) {
					System.out.println("돈이 부족합니다.");
					continue;
				} else {
					int change = money - price[sel - 1];
					System.out.print("잔돈: ");
					for (int i = 0; i < coins.length; i++) {
						int cnt = change / coins[i];
						if (cnt > 0) {
							System.out.print(String.format("%d(%d) ", coins[i], cnt));
						}
						change %= coins[i];
						if (change == 0)
							break;
					}
					System.out.println("\n");
				}
			}
		}
	}

}
