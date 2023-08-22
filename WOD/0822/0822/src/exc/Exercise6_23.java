package exc;

/*
 * 메서드명 : max
 기 능 : 주어진 int형 배열의 값 중에서 제일 큰 값을 반환한다.
 만일 주어진 배열이 null이거나 크기가 0인 경우, -999999를 반환한다.
 반환타입 : int 
 매개변수 : int[] arr - 최대값을 구할 배열

 */
public class Exercise6_23 {
	/*
	 * (1) max메서드를 작성하시오.
	 */
	static int max(int[] data) {
		int maxNum;
		if (data == null || data.length == 0) {
			return -999999;
		}
		for(int i = 1; i < data.length -1; i++) {
//			 내가 푼거 답답
			for(int j = 0; j < data.length - 1; j++) {
				if(!(data[j] > data[j+1])) {
					maxNum = data[j];
					data[j] = data[j+1];
					data[j+1] = maxNum;
				}
			}
			
			// 모범 답안
//			if(maxNum < data[i]) {
//				maxNum = data[i];
//			}
		}
		return data[0];
	}

	public static void main(String[] args) {
		int[] data = { 3, 2, 9, 4, 7 };
		System.out.println(java.util.Arrays.toString(data));
		System.out.println("최대값:" + max(data));
		System.out.println("최대값:" + max(null));
		System.out.println("최대값:" + max(new int[] {})); // 크기가 0인 배열
	}
}
//[3, 2, 9, 4, 7]
//최대값:9
//최대값:-999999
//최대값:-999999