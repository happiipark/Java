

class Exercise4_10 {
    public static void main(String[] args) {
        // 질문!!! 해야함
        int num = 12345;
        int sum = 0;
        
        // 내가 푼 부끄러운 거
//        int num1,num2,num3,num4,num5;
//        num1 = num / 10000; // 1
//        num2 = num / 1000 % 10; // 2
//        num3 = num / 100 % 120; // 3
//        num4 = num / 10 % 1230; // 4
//        num5 = num % 12340; //5
//        sum = num1 + num2 + num3 + num4 + num5;
       
        // 강사님 풀이
        
//      sum += num % 10; // 5
//      num /= 10; // 1234
//      sum += num % 10; // 4
//      num /= 10; // 123
//      sum += num % 10; // 3
//      num /= 10; // 12
//      sum += num % 10; // 2
//      num /= 10; // 1
//      sum += num % 10; // 1
//      num /= 10; // 0
      
      while(true) {
      	if(num == 0) break;
      	sum += num % 10;
      	num /= 10;
      }


		System.out.println("sum=" + sum);
	}
}
