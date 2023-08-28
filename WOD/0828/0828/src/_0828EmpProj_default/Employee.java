package _0828EmpProj_default;

public abstract class Employee {
// 하나라도 abstract 가 선언된 메서드가 있다면 클래스는 abstract 클래스로

	int id;
	String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee() {
	}

	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public String info() {
		return "사번 : " + id + ", 이름 : " + name;
	}

	public abstract int getPay();

}
