interface Fightable {
	void fight();
	
}

interface Helping {
	void help();
}
abstract class Unit {
	public abstract void move();
}

class Fighter extends Unit implements Fightable {
	@Override
	public void fight() {
		System.out.println("Fighter fight");
	}
	
	@Override
	public void move() {
		System.out.println("Fighter move");
	}
}
class Helper extends Unit implements Helping{
	
	@Override
	public void help() {
		System.out.println("Helper help");
	}
	
	@Override 
	public void move() {
		System.out.println("Helper move");
	}
}

class Comber extends Unit implements Fightable, Helping {
	
	@Override
	public void help() {
		System.out.println("Comber help");
	}
	
	@Override
	public void fight() {
		System.out.println("Comber fight");
	}
	
	@Override
	public void move() {
		System.out.println("Comber move");
	}
}
public class InterfaceTest1 {

	public static void main(String[] args) {
		
//		Fighter fightter =  new Fighter(); //upcating
//		fightter.fight();
		// fightter.move(); // 레퍼런스 타입에 없는 메소드 호출은 불가!
		
		Fighter fighter =  new Fighter(); //upcating
		Fightable Fightable1 = fighter;
		Fightable1.fight();
		Unit unit1 = fighter;
		unit1.move();
//		Object object = fighter;
		
		Helper helper = new Helper();
		Helping helping = helper;
		helping.help();
		Unit unit2 = helper;
		unit2.move();
		
		Comber comber = new Comber();
		Fightable fightable2 = comber;
		fightable2.fight();
		Helping helping2 = comber;
		helping2.help();
		Unit unit3 = comber;
		unit3.move();
		System.out.println("=========================");
		System.out.println("method1");
		method1(fighter);
		method1(comber);
//		method1(helper);//error
		
		System.out.println("=========================");
		System.out.println("method2");
//		method2(fighter); //error
		method2(comber);
		method2(helper);
		
		
		System.out.println("=========================");
		System.out.println("method3");
		method3(fighter);
		method3(comber);
		method3(helper);
	}
	
	static void method1(Fightable unit) {
		unit.fight();
	}
	
	static void method2(Helping unit) {
		unit.help();
	}
	
	static void method3(Unit unit) {
		unit.move();
	}
}
