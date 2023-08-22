package exc;

public class Exercise6_20 {
	static int[] shuffle(int[] arr) {
		// 배열 복사 방법 1. 
//		int[] mixarr = new int[arr.length];
//		System.arraycopy(arr, 0, mixarr, 0, arr.length);
		
		// 배열 복사 방법 2.
		int[] mixarr = arr.clone();
		for (int i = 0; i < 100; i++) {
			int idx1 = (int) (Math.random() * arr.length);
			int idx2 = (int) (Math.random() * arr.length);
			int temp = arr[idx1];
			arr[idx1] = arr[idx2];
			arr[idx2] = temp;
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] original = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(java.util.Arrays.toString(original));
		System.out.println("===== mix 전 =======");
		int[] result = shuffle(original);
		System.out.println(java.util.Arrays.toString(original));
		System.out.println(java.util.Arrays.toString(result));
	}
}

//[1, 2, 3, 4, 5, 6, 7, 8, 9]
//[4, 6, 8, 3, 2, 9, 7, 1, 5]