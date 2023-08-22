
public class Company {
	
	public static void main(String[] args) {
		Company com = new Company();

		Employee emp1 = new Employee(10001, "홍길동", "홍보부", 5000000);
		Employee emp2 = new Employee(10002, "고길동", "총보부", 5000000);
		Employee emp3 = new Employee(10003, "하길동", "개발부", 5000000);

		com.enter(emp1);
		com.enter(emp2);
		com.enter(emp3);
		com.setBonus(10001, 1000000);

		com.allEmployeeInfo();
		System.out.println("총급여액 : " + com.getTotalPay());
	}

}

// 사번 : 10001, 이름 : 홍길동, 부서 : 홍보부, 급엽 : 6000000
// 사번 : 10002, 이름 : 고길동, 부서 : 총무부, 급엽 : 3500000
// 사번 : 10003, 이름 : 하길동, 부서 : 개발부, 급엽 : 4000000
// 총급여액 : 
