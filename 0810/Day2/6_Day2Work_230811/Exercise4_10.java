package org.example;

class Exercise4_10 {
    public static void main(String[] args) {
        // 질문!!! 해야함
        int num = 12345;
        int sum = 0;

        int num1,num2,num3,num4,num5;
        num1 = num / 10000; // 1
        num2 = num / 1000 % 10; // 2
        num3 = num / 100 % 120; // 3
        num4 = num / 10 % 1230; // 4
        num5 = num % 12340; //5
        sum = num1 + num2 + num3 + num4 + num5;


        System.out.println("sum=" + sum);
    }
}
