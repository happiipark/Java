package KOSTA._0822;

public class Company {

    Employee[] emp = new Employee[100];
    static int empCnt = 0;

    void enter(Employee emp) {
        this.emp[empCnt++] = emp;
    }

    void allEmployeeInfo() {
        for (int i = 0; i < empCnt; i++) {
            System.out.println(emp[i].info());
        }
    }


    // 사번 찾기
    Employee searchById(int id) {
        Employee res = null;
        for (int i = 0; i < empCnt; i++) {
            if (emp[i].id == id) {
                res = emp[i];
                break; // break 를 걸어줘서 다음 반복이 진행되지 않게끔 원하는 사번 하나만 찾으면 되기 때문에!
            } else {
                res = null;
            }
        }
        return res;
    }

    void setBonus(int id, int bonus) {
        Employee emp = searchById(id);
        if (emp == null) {
            System.out.println("잘못된 사번을 입력하였습니다.");
        } else {
            emp.salary += bonus;
        }
    }

    int getTotalPay() {
        int totalSalary = 0;  // 총급여
        for (int i = 0; i < empCnt; i++) {
            totalSalary += emp[i].salary;
        }
        return totalSalary;
    }

    public static void main(String[] args) {

        Company com = new Company();


        Employee emp1 = new Employee(10001, "홍길동", "홍보부", 5000000);
        Employee emp3 = new Employee(10003, "하길동", "개발부", 5000000);
        Employee emp2 = new Employee(10002, "고길동", "총보부", 5000000);

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
