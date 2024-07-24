package week3.chapter6.problem10;

import java.util.Arrays;
import java.util.Scanner;

public class ShellSortV2 {
    static int moveCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("요솟수: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "] : ");
            arr[i] = scanner.nextInt();
        }

        shellSort(arr, n);

        System.out.println("정렬 후 : " + Arrays.toString(arr));

        System.out.println("moveCount = " + moveCount);
    }

    private static void shellSort(int[] arr, int n) {

        int h;
        for (h = 1; h < n; h = h * 3 + 1) ;

        for (; h>0; h/=3) {
            for (int i = h; i < n; i++) {
                int j;
                int temp = arr[i];
                for (j = i-h;  j>=0 && arr[j]>temp ; j-=h) {
                    moveCount ++;
                    arr[j+h] = arr[j];
                }
                arr[j+h] = temp;
                moveCount ++;
            }
        }

    }
}
