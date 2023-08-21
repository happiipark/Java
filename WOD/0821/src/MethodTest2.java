

class Data{
	int x;
}

public class MethodTest2 {
	static void increment(int x) { // 기본형 매개변수 - 변수의 값을 읽기만 할 수 있다 - read only
		x += 1;
		System.out.println(x); // 11
	}
	static void increment2(Data d) { // 참조형 매개변수 - 변수의 값을 읽고 변경할 수 있다 - read & write
		d.x += 1;
		System.out.println(d.x); // 11
	}
	public static void main(String[] args) {
		Data data = new Data();
		data.x = 10;
		
		increment(data.x);
		System.out.println(data.x); // 10
		
		increment2(data);
		System.out.println(data.x); // 11
	}

}
