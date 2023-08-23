import pac.Number;

//class Number {
//	private int pnum;
//	private void pmethod() {
//		pnum = 10;
//	}
//	
//	int dnum;  //default
//	void dmethod() { //default
//		System.out.println(pnum);
//	}  
//	
//	public int punum;
//	public void pumethod() {
//		System.out.println(pnum);
//	}
//
//}

public class AccessTest1 {

	public static void main(String[] args) {
		Number n1 = new Number();
//		n1.pnum = 100; // 다른 클래스의 private 멤버는 접근 불가
//		n1.pmethod();
		
//		n1.dnum = 100;  // 같은 패키지에 있는 클래스의 default 멤버 접근 가능
		n1.setDnum(100);
		n1.dmethod();
		
		n1.punum = 100;  // 다른 클래스의 public 멤버는 어디서든 접근 가능
		n1.pumethod();
		
//		n1.prnum = 100; // 자식도 아니고 같은 패지키도 아니면 protected는 접근 불가
	}
}
