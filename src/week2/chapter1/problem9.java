package week2.chapter1;

import java.util.Scanner;

public class problem9 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a, b;
        System.out.print("a값: ");
        a = scanner.nextInt();
        do {
            System.out.print("b값: ");
            b = scanner.nextInt();
            if(b<=a) {
                System.out.println("a보다 큰 값을 입력하세요!");
            } else {
                System.out.println("b - a 는 " + (b-a) +"입니다.");
            }
        } while (b<=a);
    }
}
