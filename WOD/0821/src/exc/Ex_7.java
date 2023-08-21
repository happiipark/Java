package exc;

class MyPoint {
	int x;
	int y;

	MyPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public MyPoint() {
		
	}

	// 내가 푼 거
//	double getDistance(int x, int y) { // 파라미터 들어온 좌표
//		double xDistance = Math.pow(this.x - x, 2);
//		double yDistance = Math.pow(this.y - y, 2);
//		return Math.sqrt(xDistance + yDistance);
//	}
	
	// 강사님이 푼거
//	double getDistance(int x1, int y1) {
//		return Math.sqrt((x-x1)*(x-x1) + (y-y1)*(y-y1));
//	}
	
	double getDistance(MyPoint pos) {
		return Math.sqrt((x-pos.x)*(x-pos.x) + (y-pos.y)*(y-pos.y)); 
	}
}

public class Ex_7 {

	public static void main(String[] args) {
//		MyPoint p = new MyPoint(1, 1);
		// p(1,1)과 (2,2)의 거리를 구한다.
//		System.out.println(p.getDistance(2, 2));
		
		MyPoint pos1 = new MyPoint();
		pos1.x = 1;
		pos1.y = 1;
		
		MyPoint pos2 = new MyPoint();
		pos2.x = 2;
		pos2.y = 2;
	
		System.out.println(pos1.getDistance(pos2));
	}

}
