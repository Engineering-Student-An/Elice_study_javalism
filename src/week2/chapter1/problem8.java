package week2.chapter1;

import java.util.Scanner;

public class problem8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println("sumof(a, b) = " + sumof(a, b));
    }

    private static int sumof(int a, int b) {
        int start = Math.min(a, b);
        int end = Math.max(a, b);

        int sum = 0;
        for(int i = start; i <= end; i ++) {
            sum += i;
        }

        return sum;
    }
}

