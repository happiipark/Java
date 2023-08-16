package org.example;

public class Exercise4_5 {
    public static void main(String[] args) {
//        for (int i = 0; i <= 10; i++) {
//            for (int j = 0; j <= i; j++)
//                System.out.print("*");
//            System.out.println();
//        }

        // while 로 변환
        int i=1,j=1;
        while(i <= 10){
            j = 1 ;  // 질문 :  j = 1 을 안 해줄경우 i와  j 의 값이 같이 올라가서 * 이 한개씩만 출력 while 문 사용시 꼭 초기화 해야하는지?
            while(j <= i){
                System.out.print("*");
                j++;
            }
            i++;
            System.out.println();
        }
    }
}
