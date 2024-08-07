package week3.chapter6;

import java.util.Scanner;

public class Problem4 {
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

        bubbleSort(arr, n);
    }

    private static void bubbleSort(int[] arr, int n) {
        int k = 0;
        int pass = 0;
        while(k < n-1) {
            int last = n-1;
            System.out.println("패스 " + (++pass) + ":");
            for (int j = n-1; j > k; j--) {
                if(arr[j-1] > arr[j]) {
                    print(arr, j-1, true);
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                    count ++;
                    last = j;
                } else {
                    print(arr, j-1, false);
                }
            }
            print(arr, -2, false);
            k = last;
        }

        System.out.printf("비교를 %d회 했습니다.\n", comp);
        System.out.printf("교환을 %d회 했습니다.", count);
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
