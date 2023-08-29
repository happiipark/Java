
public class StringTest1 {
	public static void main(String[] args) {
		String a = "a";
		a = "b";
		
		int n = 10;
		n = 20;
		
		String s1 = null;
		String s2 = ""; // String은 null을 포함. 빈 문자열 선언 오류 안 남
		char c = ' ';   
		
		String s3 = new String("abc");
		char[] carr = {'a','b','c'};
		String s4 = new String(carr);
		System.err.println(s3);
		System.err.println(s4);
		
		StringBuffer sb = new StringBuffer("abc");
		String s5 = new String(sb);
		System.out.println(s5);
		
		String bs = "hello";
		String cs = bs.concat("world"); // concat 문자열 이어주는 메서드
		System.out.println(bs);
		System.out.println(cs);
		System.out.println("문자열 포함 여부를 확인하는 메서드 contains : " + cs.contains("hello"));  // contains 문자열 포함 여부
		
		String filename = "text.txt";
		System.out.println("지정된 문자열로 끝나는지 검사 메서드 endsWith : "+filename.endsWith("hwp"));
		
		String[] files = {"test.txt", "temp.hwp", "backup.txt"};
		for(int i = 0; i <files.length; i++) {
			if(files[i].endsWith("txt")) {
				System.out.println(files[i]);
			}
		}
	}

}
