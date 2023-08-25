abstract class Player {
	int currentPos;
	public Player() {
		currentPos=0;
	}
	
	abstract void play(int pos);
	abstract void stop();
	void play() {
		play(currentPos);
	}
}
//abstract class를 상속받으면 abstract method를 반드시 구현하지 않으면,
//상속받은 자식 클래스도 abstract 클래스여야 한다
class DPlayer extends Player { 
	
	@Override
	void play(int pos) {
		System.out.println("DPlayer play(int pos)");
	}
	
	@Override
	void stop() {
		System.out.println("DPlayer stop()");
	}
}
public class AbstractTest1 {
	public static void main(String[] args) {
		// Player player = new Player(); // abstract class는 객체 생성 불가능
		DPlayer dPlayer = new DPlayer();
		dPlayer.play();
		dPlayer.stop();
		
		Player player = new DPlayer(); // upcasting
		player.play();
		player.stop();
		
	}
}
