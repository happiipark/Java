package _0828EmpProj;
import _0828EmpProj_default.Employee;
import _0828EmpProj_default.Trip;
public class Company {
	Employee[] emps = new Employee[100];
	int empCnt=0;
	public void enter(Employee emp) { //Employee emp=emp1// upcasting
		emps[empCnt++] = emp;
	}
	
	public void allEmployeeInfo() {
		for(int i=0; i<empCnt; i++) {
			System.out.println(emps[i].info());
		}
	}
	
	public int getTotalPay() {
		int tot=0;
		for(int i=0; i<empCnt; i++) {
			tot += emps[i].getPay();
		}
		return tot;
	}
	
//	public void regBusinessTrip(Trip emp,int day) {  
//		// sales랑 partTime만 출장가능 , 단 출장 비용이 다름
//		emp.trip(emp, day);
//	}
	public void regBusinessTrip(Trip emp,int day) {  
		// sales랑 partTime만 출장가능 , 단 출장 비용이 다름
		emp.trip(day);
	}
	
	
	
}
