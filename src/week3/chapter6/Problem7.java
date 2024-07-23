package week3.chapter6;

import java.util.Scanner;

public class Problem7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("요솟수: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "] : ");
            arr[i] = scanner.nextInt();
        }

        insertionSort(arr, n);
        print(arr, -1, -1);
    }

    private static void insertionSort(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            int j;
            int tmp = arr[i];
            for (j = i; j > 0 && arr[j-1] > tmp; j--) {
//                arr[j] = arr[j-1];
            }
//            arr[j] = tmp;
            print(arr, i, j);
            for (int k = i; k > j ; k--) {
                arr[k] = arr[k-1];
            }
            arr[j] = tmp;
        }
    }

    private static void print(int[] arr, int i, int j) {
        for (int k = 0; k < arr.length; k++) {
            System.out.printf("%4d", arr[k]);
        }
        System.out.println();
        for (int k = 0; k < arr.length; k++) {
            if(i == j) {
                if(k == i) {
                    System.out.printf("%4s", "+");
                }
                else {
                    System.out.print("    ");
                }
            } else {
                if(k == i) {
                    System.out.printf("---+");
                } else if(k == j) {
                    System.out.printf("%4s", "^");
                } else if(k>j && k<i) {
                    System.out.print("----");
                } else {
                    System.out.print("    ");
                }
            }
        }
        System.out.println();
    }
}
