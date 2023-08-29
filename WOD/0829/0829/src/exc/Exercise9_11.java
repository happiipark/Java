package exc;

public class Exercise9_11 {

	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("시작 단과 끝 단, 두 개의 정수를 입력해주세요.");
			System.out.println("USAGE : GugudanTest" + args[0] + " " + args[1]);
		}

		int s = Integer.parseInt(args[0]);
		int e = Integer.parseInt(args[1]);
		
		if(s>e) {
			int t = s;
			s = e;
			e = t;
		}

		if (s < 2 || e > 9) {
			System.out.println("단의 범위는 2와 9사이의 값이어야 합니다.");
			System.out.println("USAGE : GugudanTest " + s + " " + e);

		} else {
			for (int i = s; i <= e; i++) {
				for (int j = 1; j <= 9; j++) {
					System.out.println(String.format("%d x %d = %d", i, j, i * j));
				}
			}
		}
	}

}
