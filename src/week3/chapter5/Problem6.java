package week3.chapter5;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem6 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.println("변경 전");
        recur3(n);
        System.out.println();

        System.out.println("변경 후");
        modifiedRecur3(n);
    }

    static void modifiedRecur3(int n) {
        String[] arr = new String[n+1];
        arr[0] = "";
        arr[1] = "1";
        for (int i = 2; i <= n; i++) {
            if(i==2) {
                arr[i] = arr[i-1] + " " + i;
            } else {
                arr[i] = arr[i-1] + " " + arr[i-2] + " " + i;
            }

        }
        System.out.println(arr[n]);
    }

    static void recur3(int n) {
        if(n>0) {
            recur3(n-1);
            recur3(n-2);
            System.out.print(n + " ");
        }
    }
}
