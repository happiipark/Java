package exc;

public class Exercise5_12 {

	public static void main(String[] args) {
		// 숙제
		// 3m 짜리 우물 바닥에 달패이가 존재
		// 달팽이는 낮동안 55cm 올라올 수 있다. 하지만 날이 지면 잠을 자야 한다.
		// 자는 동안 미끄러져 3cm를 미끄러져 내려온다.
		// 달팽이가 우물 밖으로 나오는데 며칠이 걸리는지 구하시오.
		// 올라오는 행위가 하루

		int well = 300; // 우물 높이
		int climbWell = 55; // 하루당 올라가는 거리
		int slipWell = 3; // 미끄러져 떨어지는 거리
		int totDistance = 0; // 이동거리
		int day = 0;
		
		for(day = 1;; ++day) {
			System.out.println(day);
			totDistance = totDistance + climbWell - slipWell;
			if(totDistance >= well) {
			System.out.println(totDistance);
			System.out.println(day);
			break;
			}
		}
	}
}
// 1 :  55 - 2 = 53
// 2 :  53 + 55 - 2 = 106
// 3 :  106 + 55 - 2 = 159
// 4 :  159 + 55 - 2 = 212
// 5 :  212 + 55 - 2 = 265
// 6 :  265 + 55