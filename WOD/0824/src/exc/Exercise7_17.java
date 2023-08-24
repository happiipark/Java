package exc;

public class Exercise7_17 {

	abstract class Unit {
		int x, y;

		Unit() {
		}

		Unit(int x, int y) {
			this.x = x;
			this.y = y;
		}

		abstract void move(int x, int y);

		void stop() {

		}
	}

	class Marine extends Unit {

		void move(int x, int y) {
			System.out.println("걸어 간다.");
		}

		void stimPack() {
			System.out.println("스팀팩을 사용한다.");
		}
	}

	class Tank extends Unit {
		void move(int x, int y) {
			System.out.println("탱크로 이동한다.");
		}

		void changeMode() {
			System.out.println("공격모드 변환");
		}
	}

	class Dropship extends Unit {
		void move(int x, int y) {
			System.out.println("날아 간다.");
		}

	}
}
