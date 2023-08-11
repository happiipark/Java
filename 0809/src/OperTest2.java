
public class OperTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int i = -10;
		i = +i; // i * 1
		System.out.println(i); // -10 출력
		i = -i; // i * (-1)
		System.out.println(i); // 10 출력
		
		boolean power = false;
		power = !power;
		System.out.println(power); // true 출력
		power = !power;
		System.out.println(power); // false 출력
		
		int j = 10;
		System.out.println(j);
		j = ~j; // ~ 1의 보수 취하기
		System.out.println(j);
	}

}
