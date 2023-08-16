

import java.util.Scanner;

public class Exercise4_1 {
    public static void main(String[] args) {
        // 1. int형 변수 x가 10보다 크고 20보다 작을 때 true인 조건식
//        Scanner sc = new Scanner(System.in);
//        System.out.print("x의 값을 입력 : ");
//        int x = sc.nextInt();
//        System.out.println((x>10 && x<20) ? true : false);

        // 2. char형 변수 ch가 공백이나 탭이 아닐 때 true인 조건식
        Scanner sc = new Scanner(System.in); // 질문 : 공백이나 tab을 입력 받는 방법이 궁금합니다!!
        System.out.print("ch의 값을 입력 : ");
        char ch = sc.next().charAt(0);
        System.out.println((ch != ' ' && ch != '\t') ?  true : false);

        // 3. char형 변수 ch가 ‘x' 또는 ’X'일 때 true인 조건식
//        Scanner sc = new Scanner(System.in);
//        System.out.print("ch의 값을 입력 : ");
//        char ch = sc.next().charAt(0);
//        System.out.println((ch == 'x' || ch == 'X') ?  true : false);

        // 4. char형 변수 ch가 숫자(‘0’~‘9’)일 때 true인 조건식
        // 문자를 입력받아서 표현하려 했으나 문자열을 받고 문자열의 첫번째 자리를 추출하여 문자로 저장하는 방식을 사용하다 보니 10이 넘어가는 숫자는 판단불가
//        Scanner sc = new Scanner(System.in);
//        System.out.print("ch의 값을 입력 : ");
//        if (sc.next().length() == 2) {
//            char ch0 = sc.next().charAt(0);
//            char ch1 = sc.next().charAt(1);
//            char ch = (char)(ch0 + ch1);
//            System.out.println((ch >= '0' && ch <= '9') ? true : false);
//        } else {
//            char ch = sc.next().charAt(0);
//            System.out.println((ch >= '0' && ch <= '9') ? true : false);
//        }

        // 5. char형 변수 ch가 영문자(대문자 또는 소문자)일 때 true인 조건식
//        Scanner sc = new Scanner(System.in);
//        System.out.print("ch의 값을 입력 : ");
//        char ch = sc.next().charAt(0);
//        int chatToNumber = (int) ch;  // 대문자인지 소문자인지 확인하기 위해 아스키 코드의 값으로 입력 받은 문자를 변환
//        System.out.println((chatToNumber >= 65 && chatToNumber <= 122) ? true : false); // 변환한 아스키 코드 값으로 사이에 있으면 대문자 혹은 소문자로 인정


        // 6. int형 변수 year가 400으로 나눠떨어지거나 또는 4로 나눠떨어지고 100으로 나눠떨어지지 않을 때 true인 조건식
//        Scanner sc = new Scanner(System.in);
//        System.out.print("변수 year 입력 : ");
//        int year = sc.nextInt();
//        System.out.println((year % 400 == 0 || (year % 4 == 0 && year % 100 != 0) ? true : false));

        // 7. boolean형 변수 powerOn가 false일 때 true인 조건식
//        Scanner sc = new Scanner(System.in);
//        System.out.print("powerOn 의 값을 입력 : ");
//        boolean powerOn = sc.nextBoolean();
//        System.out.println(powerOn == false ? true : false);

        // 8. 문자열 참조변수 str이 “yes”일 때 true인 조건식
//        Scanner sc = new Scanner(System.in);
//        System.out.print("str의 값 입력 : ");
//        String str = sc.next();
//        System.out.println(str.equals("yes"));
    }
}
