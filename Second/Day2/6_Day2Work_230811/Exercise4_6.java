package org.example;

public class Exercise4_6 {
    public static void main(String[] args) {
        // 두 개의 주사위를 던졌을 때, 눈의 합이 6이 되는 모든 경우의 수를 출력하는 프 로그램을 작성하시오.
        // 1번 주사위 1,2,3,4,5
        // 2번 주사위 5,4,3,2,1
        int dice1, dice2;
//        dice1 = (int)(Math.random()*6)+1;
//        dice2 = (int)(Math.random()*6)+1;
        for(dice1 = 1; dice1 <= 6; dice1++){
            for(dice2 = 1; dice2 <= 6; dice2++){
                if(dice1 + dice2 == 6){
                    System.out.println("1번 주사위의 값 : " + dice1);
                    System.out.println("2번 주사위의 값 : " + dice2);
                }
            }
            System.out.println();
        }
    }
}
