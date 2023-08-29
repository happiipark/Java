package exc;

class Exercise9_9 {
	/*
	 * (1) delChar메서드를 작성하시오.
	 */

	static String delChar(String src, String delCh) {
		
		// String -> StringBuffer
		StringBuffer chSrc = new StringBuffer(src);
		StringBuffer chdel = new StringBuffer(delCh);
		
		// 인덱스 번호 찾기
		int idx = 0;
		
		for(int i = 0; i < chSrc.length(); i++) {
			for(int j = 0; j < chdel.length(); j++) {
				if(chSrc.charAt(i) == chdel.charAt(j)) {
					idx = chSrc.indexOf(""+chSrc.charAt(i));
					chSrc.deleteCharAt(idx);
				}
			}
		}
		return new String(chSrc);
	}

	public static void main(String[] args) {
		System.out.println("(1!2@3^4~5)" + " -> " + delChar("(1!2@3^4~5)", "~!@#$%^&*()"));
		System.out.println("(1 2 3 4\t5)" + " -> " + delChar("(1 2 3 4\t5)", " \t"));
	}
}
