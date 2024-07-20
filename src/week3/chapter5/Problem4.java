package week3.chapter5;

import java.util.Scanner;

public class Problem4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        recur2(n);
    }

    static void recur2(int n) {
        if(n>0) {
            recur2(n - 2);
            System.out.println(n);
            recur2(n - 1);
        }
    }
}
