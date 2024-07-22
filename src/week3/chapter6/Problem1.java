package week3.chapter6;

import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("요솟수: ");
        int n = scanner.nextInt();
        int[] arr = new int [n];
        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "]: ");
            arr[i] = scanner.nextInt();
        }

        bubbleSort(arr, n);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    static void bubbleSort(int[] arr, int n) {
        for (int i = n-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
