package item;

public class Tank extends GroundUnit implements Repairable{
	
	public Tank() {
		super(150);
	}
	
	public void fix(){ //90
		healthPoint = (int)Math.round(MAX_HP*0.9);
	}

}
