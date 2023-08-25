package item;

public class SCV extends GroundUnit implements Repairable {

	public SCV() {
		super(60);
	}

	public void repair(Repairable r) {
//		if (r instanceof Unit) {
//			Unit unit = (Unit) r;
//			unit.healthPoint = unit.MAX_HP;
//		}
		r.fix();
	}

	public void fix() { // 80
		healthPoint = (int) Math.round(MAX_HP * 0.8);
	}

}
