package week3.chapter6;

import java.util.Scanner;

public class Problem8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("요솟수: ");
        int n = scanner.nextInt();
        int[] arr = new int[n+1];

        for (int i = 1; i <= n; i++) {
            System.out.print("arr[" + i + "] : ");
            arr[i] = scanner.nextInt();
        }

        insertionSort(arr, n+1);

        System.out.println("정렬 후");
        for (int i = 1; i <= n; i++){
            System.out.print(arr[i] + " ");
        }
    }

    private static void insertionSort(int[] arr, int n) {
        for (int i = 2; i < n; i++) {
            int j;
            int tmp = arr[0] = arr[i];
            for (j = i; arr[j-1] > tmp; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = tmp;
        }
    }
}
