package KOSTA._0822;

public class Employee {
    int id; // 계좌 번호
    String name; // 이름
    String department; // 부서
    int salary; // 급여

    Employee(int id, String name, String department, int salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    String info() {
        return String.format("사번 : %d, 이름 : %s, 부서 : %s, 급여 : %d",
                                    id, name, department, salary);
    }
}

