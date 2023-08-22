package exc;

/*
 * 메서드명 : isNumber
   기 능 : 주어진 문자열이 모두 숫자로만 이루어져있는지 확인한다.
   모두 숫자로만 이루어져 있으면 true를 반환하고, 
   그렇지 않으면 false를 반환한다.
   만일 주어진 문자열이 null이거나 빈문자열“”이라면 false를 반환한다.
   반환타입 : boolean
   매개변수 : String str - 검사할 문자열
   [Hint] String클래스의 charAt(int i)메서드를 사용하면 문자열의 i번째 위치한 
   문자를 얻을 수 있다.
 * 
 */



public class Exercise6_22 {
	/*
	 * (1) isNumber메서드를 작성하시오.
	 */
	
	static boolean isNumber(String str) {
		if(str==null || str.length()==0) return false;
		boolean res = true;
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(!(ch >= '0' && ch <= '9')) {
				res = false;
				break; 
			}  else {
				res = true;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		String str = "123";
		System.out.println(str + "는 숫자입니까? " + isNumber(str));
		str = "1234o";
		System.out.println(str + "는 숫자입니까? " + isNumber(str));
	}
}
//123는 숫자입니까? true
//1234o는 숫자입니까? false