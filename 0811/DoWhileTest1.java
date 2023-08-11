import java.util.Scanner;

public class DoWhileTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		// 0 으로 초기화 하지 않을 경우 sum+=5; 같은 연산 불가능
		int in;
		
		// 1. do while 
//		do {
//			System.out.print("숫자 입력 : ");
//			in = sc.nextInt();
//			sum += in;
//		} while(in != 0);
//		System.out.println("입력한 숫자의 합 : " + sum);
		
		// 2 while
		in = sc.nextInt();
		while(in!=0) {
			sum += in;
			in = sc.nextInt();
		}
		System.out.println(sum);
		
	}

}
