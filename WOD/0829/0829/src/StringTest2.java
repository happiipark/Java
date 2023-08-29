import java.util.Scanner;

public class StringTest2 {
	public static void main(String[] args) {
		String str = "Good Luck";
		int idx1 = str.indexOf('L'); //
		System.out.println(idx1);
		int idx2 = str.indexOf("Good"); // 문자열이 포함된 첫번째 글자의 index 값 출력
		System.out.println("문자열이 포함된 첫번째 글자의 index 값 출력하는 메서드 indexOf : " + idx2);

		String str2 = "apple place";
		int idx3 = str2.indexOf('p');
		int idx4 = str2.lastIndexOf('p');
		System.out.println(idx3);
		System.out.println("문자열의 원하는 문자의 마지막 위치 찾아내는 메서드 lastIndexOf : " + idx4);

		String str3 = str2.replace('p', 't');
		System.out.println("문자열의 문자를 원하는 문자로 바꿔주는 메서드 replace : " + str3);
		System.out.println(str2);

		String str4 = str2.replace("place", "banana");
		System.err.println("문자열의 문자열을 원하는 문자열로 바꿔주는 메서드 replace : " + str4);

		String fruitStr = "apple,banana,pineapple,melon,strawberry";
		String[] fruitArr = fruitStr.split("#",3);
		for (int i = 0; i < fruitArr.length; i++) {
			System.out.println(fruitArr[i]);
		}
		String pineapple = fruitStr.substring(13,22); // 첫번재 인덱스 부터 두번째 인덱스 -1 까지 잘르기
		System.out.println(pineapple);
		
//		System.out.print("Y/N를 선택하세요 : ");
//		Scanner sc = new Scanner(System.in);
//		String answer = sc.nextLine();
//		if(answer.toLowerCase().equals("y")) {
//			System.out.println("문자열을 소문자로 바꿔주는 메서드 toLowerCase");
//			System.out.println("Y 선택");
//			
//		} else if(answer.toUpperCase().equals("N")) {
//			System.out.println("문자열을 대문자로 바꿔주는 메서드 toUpperCase");
//			System.out.println("N 선택");
//		} 
		
		
		String str5 = "     trim()    ";
		System.out.println("문자열의 앞뒤 공백을 제거해주는 메서드 trim() : "+str5.trim());
		
		Point p = new Point(10,10);
		String str6 = String.valueOf(p);
		String str7 = ""+ p;
		System.out.println(str6);
		System.out.println(str7);

	}

}
