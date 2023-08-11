package org.example;

public class Exercise4_12 {
    public static void main(String[] args) {
        // 구구단
        for (int i = 1; i <= 3; i++) {
            for (int j = 2; j <= 4; j++) {
                System.out.print(String.format("%d X %d = %2d\t", j, i, j * i));
            }
            System.out.println();
        }
        for (int i = 1; i <= 3; i++) {
            for (int j = 5; j <= 7; j++) {
                System.out.print(String.format("%d X %d = %2d\t", j, i, j * i));
            }
            System.out.println();
        }
        for (int i = 1; i <= 3; i++) {
            for (int j = 8; j <= 9; j++) {
                System.out.print(String.format("%d X %d = %2d\t", j, i, j * i));
            }
            System.out.println();
        }


    }
}
