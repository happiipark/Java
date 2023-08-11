
public class ArrayTest2 {

	public static void main(String[] args) {
//		nt[] narr1 = new int[] {1,2,3,4,5}; // 배열 선언과 초기화 1
		int[] narr1; // 위와 같음
		narr1 = new int[] {1,2,3,4,5};
		
		
		// 선언과 동시에 초기화 할 경우 new int[] [] 안에 값 지정 불가
		int[] narr2 = {1,2,3,4,5}; // 배열 선언과 초기화 2 // 변수 선언과 초기화를 같이 할 경우 new int[]를 생략 가능!!
//		int[] narr2;
//		narr2 = {1,2,3,4,5}; // 불가능(변수 선언과 초기화를 따로 할 경우 new int[]를 생략할 수 없다)
		
		int n = narr1[2]; // n = 3
	}

}
