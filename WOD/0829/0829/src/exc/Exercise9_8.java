package exc;

class Exercise9_8 {
	/*
	 * (1) round메서드를 작성하시오.
	 */

	static double round(double d, int n) {
		
		double src = 0.0;
		
		int nn = (int)Math.pow(10, n);
		
//		double dd = d * nn;
//		double ddd = Math.round(dd);
//		
//		double nnn = Math.pow(0.1, n);
//		
//		double dddd = ddd * nnn;
//		
//		
//		return Math.round(d*nn)/nn;
		src = Math.round(d* nn);
		src = src / nn;
		return src;
	}

	public static void main(String[] args) {
		System.out.println(round(3.1415, 1));
		System.out.println(round(3.1415, 2));
		System.out.println(round(3.1415, 3));
		System.out.println(round(3.1415, 4));
		System.out.println(round(3.1415, 5));
	}
}