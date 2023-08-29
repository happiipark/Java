package exc;

class Exercise9_7 {
	/*
	 * (1) contains메서드를 작성하시오.
	 */
	static boolean contains(String s1, String s2) {
		if(s1.contains(s2)) return true;
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(contains("12345", "23"));
		System.out.println(contains("12345", "67"));
	}
}