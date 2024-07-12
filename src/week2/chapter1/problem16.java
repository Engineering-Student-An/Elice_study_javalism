package week2.chapter1;

import java.util.Scanner;

public class problem16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        nspira(n);
    }

    private static void nspira(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n-i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < (i-1)*2+1; j++) {
                System.out.print(i%10);
            }
            System.out.println();
        }
    }
}
