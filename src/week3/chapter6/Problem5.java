package week3.chapter6;

import java.util.Scanner;

public class Problem5 {
    static int comp = 0;
    static int count = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("요솟수: ");
        int n = scanner.nextInt();
        int[] arr = new int [n];
        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "]: ");
            arr[i] = scanner.nextInt();
        }

        shakerSort(arr, n);
    }

    private static void shakerSort(int[] arr, int n) {
        int left = 0;
        int right = n-1;

        int last = left;
        int pass = 0;
        while(left < right) {
            System.out.println("패스 " + (++pass) + ":");
            for (int i = left; i < right; i++) {
                if(arr[i] > arr[i+1]) {
                    print(arr, i, true);
                    swap(arr, i, i+1);

                    last = i;
                } else {
                    print(arr, i, false);
                }
            }
            right = last;

            for (int i = right; i > left; i--) {
                if (arr[i - 1] > arr[i]) {
                    print(arr, i-1, true);
                    swap(arr, i - 1, i);

                    last = i;
                } else {
                    print(arr, i-1, false);
                }
            }
            left = last;

            print(arr, -2, false);
        }
        System.out.printf("비교를 %d회 했습니다.\n", comp);
        System.out.printf("교환을 %d회 했습니다.", count);
    }

    private static void swap(int[] arr, int i, int j) {
        count ++;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void print(int[] arr, int j, boolean b) {
        if(j!=-2) comp ++;
        for (int i = 0; i < arr.length; i++) {

            if (i == j+1) {
                // + 또는 -를 4칸의 공간 가운데에 출력
                System.out.print((b) ? (" + " + arr[j+1]) : (" - "+arr[j+1]));
            } else {
                System.out.printf("%4d", arr[i]);
            }
        }

        System.out.println();
    }
}
