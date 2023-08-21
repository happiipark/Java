package exc;

class Student {
	String name; // 학생이름
	int ban; // 반
	int no; // 번호
	int kor = 0; // 국어 점수
	int eng = 0; // 영어 점수
	int math = 0; // 수학 점수


	int getTotal() {
		return kor + eng + math;
	}

	//  내가한거
//	float getAverage() {
//		return Math.round((float)getTotal()/3*10)/10.0f;
//	}
	
	// 강사님이 한 거
	float getAverage() {
		float avg = (float)getTotal()/3;
		return Math.round(avg*10)/10.0f;
	}
	
	public Student() {
	}
	
	public Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	String info() {
		return name + ", " + ban + ", " + no + ", " + kor + ", " + eng + ", " + math + ", "+ getTotal() + ", " + getAverage();
	}

}

public class Ex3_4_5 {

	public static void main(String[] args) {
		Student s = new Student();
		s.name = "홍길동";
		s.ban = 1;
		s.no = 1;
		s.kor = 100;
		s.eng = 60;
		s.math = 76;
		System.out.println("이름:" + s.name);
		System.out.println("총점:" + s.getTotal());
		System.out.println("평균:" + s.getAverage());
		
		Student s1 = new Student("홍길동",1,1,100,60,76);
		System.out.println(s1.info());
	}

}
