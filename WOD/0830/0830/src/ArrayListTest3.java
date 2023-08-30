import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class Account {
	String id;
	int balance;

	Account() {
	}

	Account(String id, int balance) {
		this.id = id;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return String.format("계좌번호 : %s, 잔액 : %d", id, balance);
	}
}

class IdCompare implements Comparator<Account> {
	@Override
	public int compare(Account o1, Account o2) {
		return o1.id.compareTo(o2.id); // asc (오름차순)
//		return o2.id.compareTo(o1.id);  //desc (내림차순)
	}

}

public class ArrayListTest3 {
	public static void main(String[] args) {
		List<Account> accs = new ArrayList<>();
		// 대부분 앞에 변수명 지정은 List로 한다 ArrayList로 하고 싶을 경우 확장서 이유?
		accs.add(new Account("10004", 100));
		accs.add(new Account("10002", 300));
		accs.add(new Account("10003", 200));

		Collections.sort(accs, new IdCompare());
//		for(Account acc : accs) {  // 향상된 for문은 데이터가 많을 경우 속도가 빠르다
//			System.out.println(acc);
//		}

//		for(int i = 0; i < accs.size(); i++) { // 배열이 아니기에 length가 아닌 size
//			System.out.println(accs.get(i));  //  accs.[i] 가 아닌 accs.get(i)
		// 반복문을 사용할 경우 반복문의 반복 횟수를 변경하는 코드가 안에 들어갈 경우 좋지 않음!
//		}

		Iterator<Account> it = accs.iterator();  // 반복자
		while (it.hasNext()) { // hasNext() 다음 데이터가 있는지 존재 유무 판단
			Account acc = it.next();
			System.out.println(acc);
		}

	}

}
