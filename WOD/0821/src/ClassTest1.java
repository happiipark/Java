

public class ClassTest1 {
	public static void main(String[] args) {
		int n;
		
		int[] arr = new int[3]; // 배열도 클래스 타입 = 레퍼런스 타입
		Student stu1 = new Student();		
		Student stu2;
		
		stu1.name = "홍길동";
		stu1.address = "서울시 금천구";
		stu1.grade = 4;
		stu1.num = 10001;
		
		System.out.println(stu1.name);
		System.out.println(stu1.address);
		System.out.println(stu1.grade);
		System.out.println(stu1.num);
		
		System.out.println(stu1.info());
		
	}

}
