
class Account {
	String id;
	String name;
	int balance;

	String info() {
		return "계좌번호 : " + id + ", 이름 : " + name + ", 잔액 : " + balance;
	}

	void deposit(int deposit) {
		balance += deposit;
	}

	void withdraw(int withdraw) {
		balance -= withdraw;
	}
	Account() {}
	
	Account(String aid, String aname, int money){
		id = aid;
		name = aname;
		balance = money;
	}
}