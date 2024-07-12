package week2.chapter2;

import java.util.Arrays;
import java.util.Scanner;

public class problem3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "] : ");
            arr[i] = scanner.nextInt();
        }

        System.out.println("sumof(arr) = " + sumof(arr));
    }

    private static int sumof(int[] arr) {
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }
        return sum;
    }
}
