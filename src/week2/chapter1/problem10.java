package week2.chapter1;

import java.util.Scanner;

public class problem10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int sum = 0;
        while(n >= 0) {
            sum ++;
            n /= 10;
            if(n==0) break;
        }
        System.out.println(sum);
    }
}
