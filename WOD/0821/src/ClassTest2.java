


class Person {
	String name;
	int age;
	
	String info() { // method 정의
		return "이름 : " + name + ", 나이 : " + age;
	}
}
public class ClassTest2 {
	public static void main(String[] args) {
		Person per1 = new Person();
		per1.name = "박행복";
		per1.age = 28;
		
//		System.out.println( "이름 : " + per1.name);
//		System.out.println( "나이 : " + per1.age);
		
		System.out.println(per1.info()); // info method 호출
		
		Person[] parr = new Person[5]; // 객체 5개가 아니라 배열 5개 생성
		parr[0] = new Person();
		parr[1] = new Person();
		parr[2] = new Person();
		parr[3] = new Person();
		parr[4] = new Person();
		// 레퍼런스 클래스 배열은 많이 사용해도 메모리 사용이 크지 않다!
		
		
	}

}
