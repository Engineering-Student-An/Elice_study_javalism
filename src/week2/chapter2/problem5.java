package week2.chapter2;

import java.util.Arrays;
import java.util.Scanner;

public class problem5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "] : ");
            arr[i] = scanner.nextInt();
        }

        int[] result = new int[n];
        rcopy(result, arr);

        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
        System.out.println("Arrays.toString(result) = " + Arrays.toString(result));
    }

    private static void rcopy(int[] result, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[arr.length-i-1];
        }
    }
}
