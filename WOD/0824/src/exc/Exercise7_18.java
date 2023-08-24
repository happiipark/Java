package exc;

class Exercise7_18 {
	/*
	 * (1) action메서드를 작성하시오.
	 */
	
	static void action(Robot r) {
		if(r instanceof DanceRobot) {
			DanceRobot d = (DanceRobot)r;
			d.dance();
			
		}
		else if(r instanceof SingRobot) {
			SingRobot s = (SingRobot)r;
			s.sing();
		}
		else if(r instanceof DrawRobot) {
			DrawRobot dr = (DrawRobot)r;
			dr.draw();
		}
	}
	public static void main(String[] args) {
		Robot[] arr = { new DanceRobot(), new SingRobot(), new DrawRobot() };
		for (int i = 0; i < arr.length; i++)
			action(arr[i]);
	} // main
}

class Robot {
	Robot(){}
}

class DanceRobot extends Robot {
	
	DanceRobot(){
	}
	
	void dance() {
		System.out.println("춤을 춥니다.");
	}
}

class SingRobot extends Robot {
	
	SingRobot(){
	}
	void sing() {
		System.out.println("노래를 합니다.");
	}
}

class DrawRobot extends Robot {
	
	DrawRobot(){
	}
	void draw() {
		System.out.println("그림을 그립니다.");
	}

}
