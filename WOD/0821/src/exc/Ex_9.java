package exc;

public class Ex_9 {
	int x = 0, y = 0; // Marine의 위치좌표(x,y)
	int hp = 60; // 현재 체력
	int weapon = 6; // 공격력
	int armor = 0; // 방어력

	void weaponUp() {
		weapon++;
	}

	void armorUp() {
		armor++;
	}

	void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
// 이 클래스의 멤버
// 중에 static을 붙여야 하는 것은 어떤 것들이고 그 이유는 무엇인가?
// (단, 모든 병사의 공격력과 방어력은 같아야 한다.)

// weaponUp, armor 모든 병사의 공격력과 방어력이 같아야 하므로 공통적으로 사용되게끔 
// static로 선언 해줘야 한다!

