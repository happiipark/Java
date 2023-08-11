
class Exercise4_9 {
    public static void main(String[] args) {
        String str = "12345";
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i); // 1 2 3 4 5 출력됨
            String num = String.valueOf(ch); // 문자를 문자열로 변경
            sum = sum +Integer.parseInt(num); // 문자열을 그대로 숫자로 변경


            // 문자를 그대로 숫자로 변경하면 아스키 코드 값으로 바뀌어 나와서 이상한 값이 더해진다
            // 아스키 코드 '1' = 49, '2' = 50 ...

            // 찾아보니 - '0' 을 하여 원하는 문자의 숫자를 숫자로 변경해서 받을 수 있고
            // -> int num = ch - '0';

            // 다른 방법으로는 Character.getNumericValue() 을 사용하여 숫자로 바로 변경 가능
            // -> int num = Character.getNumericValue(ch);
        }
        System.out.println("sum=" + sum);
    }
}
