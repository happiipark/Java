package exc;

public class Ex12 {

	public static void main(String[] args) {
		for(int i = 1; i <=3; i++) {
			for(int dan = 2; dan<=9; dan++) {
				System.out.print(String.format("%dx%d=%d\t",dan,i,dan*i));
			}
			System.out.println();
		}
	}

}
