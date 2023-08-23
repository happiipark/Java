package acc;

public class Account {
	private String id;  // 변수는 public로 하지 않는다.
	String name;
	int balance;

	public String info() {
		return "계좌번호 : " + id + ", 이름 : " + name + ", 잔액 : " + balance;
	}

	public void deposit(int deposit) {
		balance += deposit;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void withdraw(int withdraw) {
		balance -= withdraw;
	}
	Account() {}
	
	public Account(String aid, String aname, int money){
		id = aid;
		name = aname;
		balance = money;
	}
	
}