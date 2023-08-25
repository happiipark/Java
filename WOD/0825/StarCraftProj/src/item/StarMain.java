package item;

public class StarMain {
	
	public static void main(String[] args) {
		Tank tank = new Tank();
		SCV scv = new SCV();
		Zerg zerg = new Zerg();
		Marine marine = new Marine();
		
		scv.repair(tank); 
		scv.repair(scv); 
		scv.repair(zerg); 
//		scv.repair(marine); // error 
	}
	

}
