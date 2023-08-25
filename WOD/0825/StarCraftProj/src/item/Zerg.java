package item;

public class Zerg extends AirUnit implements Repairable {

	public Zerg() {
		super(200);
	}

	public void fix() { // 100
		healthPoint = (int) Math.round(MAX_HP * 1);
	}

}
