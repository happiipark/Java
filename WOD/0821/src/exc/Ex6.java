package exc;


public class Ex6 {

	static double getDistance(int x, int y, int x1, int y1) {
		double xDistance = Math.pow(x-x1,2);
		double yDistance = Math.pow(y-y1,2);
		return Math.sqrt(xDistance + yDistance);
	}
	
	public static void main(String[] args) {
		System.out.println(getDistance(1,1,2,2));
	}

}
