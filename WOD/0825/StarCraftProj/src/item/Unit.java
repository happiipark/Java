package item;

public class Unit {
	
	int healthPoint; // 힘
	final int MAX_HP;  // 파이널 변수는 초기화가 필수!
	// 명시적으로 하던가 생성자를 통해 초기화 해야한다!
	
//	Unit(){} // hp를 받아와야하기 때문에 기본 생성자를 통해 초기화 X
	//  기본생성자를 통한 초기화는 모든 값이 똑같아 진다

	Unit(int hp) {
		MAX_HP = hp;
		healthPoint=MAX_HP;
	}
}
