package week2.chapter2;

import java.util.Scanner;

public class problem6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("10진수를 기수 변환합니다.");
        System.out.print("변환하는 음이 아닌 정수: ");
        int n = scanner.nextInt();

        System.out.print("어떤 진수로 변환할까요? (2~36): ");
        int dno = scanner.nextInt();
        System.out.printf("%3d | %7d\n", dno, n);
        System.out.println("   +----------");

        String string = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuffer result = new StringBuffer();
        do {
            printInfo(dno, n/dno, n%dno);
            result.append(string.charAt(n%dno));
            n/=dno;
        } while(n > 0);

        System.out.println(dno+"진수로 " + result.reverse() + "입니다.");

    }

    private static void printInfo(int dno, int n, int mod) {
        if(n!=0) {
            System.out.printf("%3d | %7d ... %3d\n", dno, n, mod);
            System.out.println("   +----------");
        } else {
            System.out.printf("      %7d ... %3d\n", n, mod);
        }



    }
}
