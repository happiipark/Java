class Person {
	int age;
	String name;

	String info() {
		return "이름 : " + name + ", 나이 : " + age;
	}

	Person() {
		
	}

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
}

class Student extends Person {
	String major; // 전공
	int grade; // 성적
	Student(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	Student() {}
	
	Student(String name, int age, String major, int grade) {
//		this.name = name;
//		this.age = age;
//		this.major = major;
//		this.grade = grade;
		super(name,age);
		this.major = major;
		this.grade = grade;
	}

	@Override  // 부모의 메서드를 재정의 한다.
	String info() {
		return super.info() + ", 전공 : " + major + ", 학년 : " + grade;
	}
}

public class InherTest1 {
	public static void main(String[] args) {
		Student stud1 = new Student(); // 자식 객체를 통해 부모 클래스의 속성과 메서드를 사용할 수 있다.
//		Student stud1 = new Student("열심히", 20);
		stud1.name = "열심히";
		stud1.age = 20;
		stud1.major = "산업공학";
		stud1.grade = 2;
//		System.out.println(stud1.info());
		
		Student stud2 = new Student("돈많은", 40, "금융",3);
		System.out.println(stud2.info());

		Person per1 = new Person();
		per1.name = "내로남불";
		per1.age = 30;
		stud1.major = "산업공학";
		stud1.grade = 2;
//		stud1.major = "얌채과"; // 부모 객체는 자식의 속성과 메서드를 사용할 수 없다.
//		stud1.grade = 3;
//		System.out.println(per1.info());
	}

}
