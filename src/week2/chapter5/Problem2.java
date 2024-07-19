package week2.chapter5;

import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();
        int y = scanner.nextInt();

        System.out.println("두 수의 최대공약수: " + gcd(y, x));
    }

    private static int gcd(int y, int x) {
        while(y !=0) {
           int temp = x;
           x = y;
           y = temp% y;
        }

        return x;
    }
}
