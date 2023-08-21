

public class Student {
	
	String name; // 성명
	String address; // 주소
	int grade;  // 학년
	int num; // 학번

	
	String info() {
		return String.format("이름 : %s, 주소 : %s %학년 : %d ,학번 : %s", name, address,grade ,num);
	}
}
