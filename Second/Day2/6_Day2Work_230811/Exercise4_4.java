package org.example;

public class Exercise4_4 {
    public static void main(String[] args) {
        // 1+(-2)+3+(-4)+... 과 같은 식으로 계속 더해나갔을 때, 몇까지 더해야 총합이 100이상이 되는지 구하시오.
        int sum = 0;
        int mi =0; // 질문 보류 : 음수를 더하기 위해 : i에 바로 -1을 곱하니 i == 2부터 i 값이 -2로 변하여서 for문 탈출해서 이상해짐 이거 물어봐야겠음
        for (int i = 1; ; i += 2) {
            if(i % 2 ==  0){
                mi = i * -1;
            }
            sum = i + mi;
            if(sum > 100){
                System.out.println(i);
                break;
            }
        }
    }
}
