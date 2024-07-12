package week2.chapter2;

import java.util.Arrays;
import java.util.Scanner;

public class problem2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "] : ");
            arr[i] = scanner.nextInt();
        }

        for (int i = 0; i < n/2; i++) {
            System.out.println(Arrays.toString(arr));
            System.out.println("arr[" + i + "]과 arr[" + (n-i-1) + "]를 교환합니다.");
            swap(arr, i, n-i-1);
        }

        System.out.println(Arrays.toString(arr));
        System.out.println("역순 정렬 끝");
    }

    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
