package exc;

class Ex_8 {  //Ex_8
	int kind;  // 인스턴스 변수
	int num;   // 인스턴스 변수
	static int width;  // 클래스 변수
	static int height; // 클래스 변수

	Ex_8(int k, int n) {
		kind = k;   // 지역 변수
		num = n;    // 지역 변수
	}

	public static void main(String args[]) {
		Ex_8 card = new Ex_8(1, 1);
	}
}


