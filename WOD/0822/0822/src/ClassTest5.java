
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

class Bank {
	Account[] accs = new Account[100]; // 100개의 계좌를 담을 수 있는 공간이 생김
	// 실제 개설된 계좌의 개수 관리를 위해 계좌 수 카운트 변수 생성
	int accCnt; // 기본값은 0

	void makeAccount(String id, String name, int money) {
		Account acc = new Account(id, name, money);
		accs[accCnt++] = acc;
	}

	// 강사님 풀이
	void allAccountInfo() {
		for (int i = 0; i < accCnt; i++) {
			System.out.println(accs[i].info());
		}
	}

	// 내가 푼 거
//	void accountInfo(String id) {
//		for(int i = 0; i < accCnt; i++) {
//			if(accs[i].id.equals(id)) {
//				System.out.println(accs[i].info());
//			}
//		}
//	}

	// 강사님 풀이
	Account searchAccById(String id) {
		for (int i = 0; i < accCnt; i++) {
			if (accs[i].id.equals(id)) {
				return accs[i];
			}
		}
		return null;
	}

	// 강사님 풀이
	void accountInfo(String id) {
		Account acc = searchAccById(id);
//		if(acc == null) {
//			System.out.println("계좌번호가 틀립니다.");
//		} else {
//			System.out.println(acc.info());
//		}
		if (acc == null) {
			System.out.println("계좌번호가 틀립니다.");
			return;
		}
		System.out.println(acc.info());
	}

	void deposit(String id, int money) {
		Account acc = searchAccById(id);
		if (acc == null) {
			System.out.println("계좌번호가 틀립니다.");
			return;
		}
		acc.deposit(money);
	}

	void withdraw(String id, int money) {
		Account acc = searchAccById(id);
		if (acc == null) {
			System.out.println("계좌번호가 틀립니다.");
			return;
		}
		acc.withdraw(money);
	}
}

public class ClassTest5 {

	public static void main(String[] args) {
//		Account acc1 = new Account();
//		acc1.id = "10001";
//		acc1.name = "고길동";
//		acc1.balance = 100000;
//		System.out.println(acc1.info()); // 계좌번호 : 10001, 이름 : 고길동, 잔액 : 100000
//		acc1.deposit(10000);
//		System.out.println(acc1.info()); // 계좌번호 : 10001, 이름 : 고길동, 잔액 : 110000
//		acc1.withdraw(20000);
//		System.out.println(acc1.info()); // 계좌번호 : 10001, 이름 : 고길동, 잔액 : 90000

		Bank bank = new Bank();
		bank.makeAccount("10001", "고길동", 100000);
		bank.makeAccount("10002", "김길동", 200000);

		bank.allAccountInfo();

		bank.accountInfo("10001");
		// 계좌번호 : 10001, 이름 : 고길동, 잔액 : 100000

		bank.deposit("10001", 10000);
		bank.accountInfo("10001");
		// 계좌번호 : 10001, 이름 : 고길동, 잔액 : 110000

		bank.withdraw("10001", 5000);
		bank.accountInfo("10001");
		// 계좌번호 : 10001, 이름 : 고길동, 잔액 : 105000

//		System.out.println("-----------");
//		
//		bank.allAccountInfo();

		// 내 풀이
//		for (int i = 0; i < bank.accCnt; i++) {
//			System.out.println(String.format("계좌번호 : %s, 이름 : %s, 잔액 : %d", bank.accs[i].id, bank.accs[i].name,
//					bank.accs[i].balance));
//		}

	}

}
