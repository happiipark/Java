package exc;

public class Ex10 {

	public static void main(String[] args) {
		int num = 12345;
        int sum = 0;
        
//        sum += num % 10; // 5
//        num /= 10; // 1234
//        sum += num % 10; // 4
//        num /= 10; // 123
//        sum += num % 10; // 3
//        num /= 10; // 12
//        sum += num % 10; // 2
//        num /= 10; // 1
//        sum += num % 10; // 1
//        num /= 10; // 0
        
        while(true) {
        	if(num == 0) break;
        	sum += num % 10;
        	num /= 10;
        }
        		
        
        System.out.println("sum=" + sum);

	}

}
