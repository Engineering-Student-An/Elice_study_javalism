package week3.chapter6;

import java.util.Scanner;

import static java.util.Arrays.binarySearch;

public class Problem9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("요솟수: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "] : ");
            arr[i] = scanner.nextInt();
        }

        binaryInsertionSort(arr, n);

        System.out.println("정렬 후");
        for (int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
    }

    private static void binaryInsertionSort(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            int tmp = arr[i];

            int index = binarySearch(arr, 0, i,  tmp);


            if(index < 0) {
                index = -(index + 1);
            }
            System.out.println("index = " + index);
            int j;
            for (j = i; j > index ; j--) {
                arr[j] = arr[j-1];
            }

            arr[j] = tmp;
            for (int i1 : arr) {
                System.out.print(i1 + " ");
            }
            System.out.println();
        }
    }


}
