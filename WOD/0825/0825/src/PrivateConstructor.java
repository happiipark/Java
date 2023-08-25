class MyArray { 
	//  singleton object -> 생성자를 private로 선언함으로써
	// 외부에서 생성할 수 없게, 하나만 생성해서 공유!
	//private, static
	// 메모리 생성을 못 하게 하여 1개만 쓰겠다고 해둔 것?
	private int[] arr = new int[10];
	private static MyArray myArray;
	private MyArray() {}

	
	public static MyArray getMyArrayReference() {
		// static로 메서드를 선언하여 객체 생성을 안 해도 메서드 안에
		// 작성한 new MyArray의 주소값을 읽어올 수 있다
		if(myArray == null) {
			myArray = new MyArray();
		}
		return myArray;
	}
	
	public void setData(int idx, int data) {
		arr[idx] = data;
		
	}
	public int getData(int idx) {
		return arr[idx];
	}
}

public class PrivateConstructor {  // 싱글톤
	
	public static void main(String[] args) {
		
		MyArray ma1 = MyArray.getMyArrayReference();
		MyArray ma2 = MyArray.getMyArrayReference();
		System.out.println(ma1==ma2);
		ma1.setData(0, 100);
		System.out.println(ma2.getData(0));
	}

}
