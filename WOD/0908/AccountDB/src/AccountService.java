import java.sql.Connection;
import java.util.List;

public class AccountService {
	
	public void accountInfo(String id) {

		Connection conn = Dao.getConnection();
		Account acc = Dao.selectAccount(conn, id);
		if (acc == null) {
			System.out.println("계좌 정보를 확인해주세요");
		} else {
			System.out.println(acc);
		}

		Dao.close(conn);
	}

	public void makeAccount(Account acc) {
		Connection conn = Dao.getConnection();
		Account racc = Dao.selectAccount(conn, acc.getId());
		if (racc != null) {
			System.out.println("중복 계좌번호입니다.");
		} else {
			int cnt = Dao.insertAccount(conn, acc);
			if (cnt > 0) {
				System.out.println(cnt + "개 계좌가 개설되었습니다.");
			}
		}
		Dao.close(conn);
	}

	public void deposit(String id, Integer money) {
		Connection conn = Dao.getConnection();
		Account acc = Dao.selectAccount(conn, id); // 계좌 조회
		if (acc == null) {
			System.out.println("계좌 정보를 확인해주세요");
			return;
		}
		acc.deposit(money); // 가져온 계좌에 입금(테이블이 아닌 객체에 정보 수정)
		if (Dao.updateAccount(conn, acc) > 0) { // 객체 정보를 가지고 테이블 변경
			System.out.println(String.format("%s계좌 잔액은 %d원 입니다.", acc.getId(), acc.getBalance()));
		}
		Dao.close(conn);
	}

	public void withdraw(String id, int money) {
		Connection conn = Dao.getConnection();
		Account acc = Dao.selectAccount(conn, id);
		if (acc == null) {
			System.out.println("계좌 정보를 확인해주세요");
			return;
		}
		if (acc.getBalance() < money) {
			System.out.println("잔액이 부족합니다.");
			return;
		}
		acc.withdraw(money);
		if (Dao.updateAccount(conn, acc) > 0) {
			System.out.println(String.format("%s계좌 잔액은 %d원 입니다.", acc.getId(), acc.getBalance()));
		}
		Dao.close(conn);
	}

	public void allAccountInfo() {
		Connection conn = Dao.getConnection();
		List<Account> accs = Dao.selectAccountList(conn);
		for(Account acc : accs) {
			System.out.println(acc);
		}
		Dao.close(conn);
	}

}
