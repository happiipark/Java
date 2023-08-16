
public class StringPlus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int v1 =10; 
		int v2 = 20;
		// int v1 = 10, v2 = 20; 동일
		
		int res = v1 + v2;
		System.out.println(res); // 30 출력
		
		String str1 = "abc";
		String str2 = "def";
		String sres = str1+str2;
		System.out.println(sres); // +의 피연산자가 하나라도 숫자가 아니면 해당하는 피 연산자를 이어준다
		// -> abc + def -> abcdef 출력
		
		System.out.println(str1+res); // abc + 30 -> abc30 출력
		
		String seven1 = "7";
		char seven2 = '7'; 
		int seven3 = 7; 
		System.out.println(seven1+seven2+seven3); // 777 출력, seven1이 문자열이이기 때문에

		System.out.println(seven2 + seven3); // 62출력 -> seven2 의 값인 '7'의 아스키 코드갑이 55이기 때문에
		// -> '7' 의 아스키 코드값 55 + seven3 의 값 7을 더하여 62 출력
		
		System.out.println(seven2+seven3+seven1); // 627출력 앞의 seven2+seven3를 먼저 수행 후 seven3 문자열을 더해줘서 627 출력
		System.out.println("7"+'7'+7); // 777출력
		System.out.println(7+'7'+"7"); // 627출력
		System.out.println(7+7+"7"); // 147 출력
	}

}
