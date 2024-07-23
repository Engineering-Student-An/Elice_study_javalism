package week3.chapter6;

import java.util.Scanner;
public class Problem6 {
    //--- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1]; a[idx1] = a[idx2]; a[idx2] = t;
    }

    //--- 단순 선택 정렬 ---//
    static void selectionSort(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            int min = i;                // 아직 정렬되지 않은 부분에서 가장 작은 요소의 인덱스를 저장
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[min]) min = j;
            }
            print(a, i, min);
            swap(a, i, min);           // 아직 정렬되지 않은 부분의 첫 요소와 가장 작은 요소를 교환
        }
    }

    private static void print(int[] a, int i, int min) {
        for (int j = 0; j < a.length; j++) {
            if (j == i) {
                System.out.printf("%4s", "*");
            } else if (j == min) {
                System.out.printf("%4s", "+");
            } else {
                System.out.print("    ");
            }
        }
        System.out.println();
        for (int k : a) {
            System.out.printf("%4d", k);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner stdIn = new Scanner(System.in);

        System.out.println("단순 선택 정렬");
        System.out.print("요솟수: ");
        int n = stdIn.nextInt();
        int[] x = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        selectionSort(x, n);
        print(x, -1, -1);
    }
}
