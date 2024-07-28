package week4.chapter6;

import java.util.Scanner;

public class Problem17 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("도수 정렬");
        System.out.print("요솟수 : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        int max = findMax(x);
        countingSort(x, nx, max);


        System.out.println("오름차순으로 정렬하였습니다.");
        for (int i : x) {
            System.out.print(i + " ");
        }
    }

    private static void countingSort(int[] a, int n, int max) {

        int[] f = new int[max+1];
        int[] b = new int[n];

        // 1. 도수분포표
        System.out.println("1. 도수분포표 생성");
        for (int i = 0; i < n; i++) {
            f[a[i]] ++;

            printArray(max+1, f, "f");
        }

        // 2. 누적 도수분포표
        System.out.println("2. 누적 도수분포표 생성");
        for (int i = 1; i <= max; i++) {
            f[i] += f[i-1];

            printArray(max+1, f, "f");
        }

        // 3. 목표 배열
        System.out.println("3. 목표 배열 생성");
        for (int i = n-1; i >= 0; i--) {
            b[--f[a[i]]] = a[i];

            printArray(max+1, f, "f");

            printArray(n, b, "b");
        }

        // 4. 배열 복사
        System.out.println("4. 배열 복사");

        printArray(n, b, "b");

        for (int i = 0; i < n; i++) {
            a[i] = b[i];

            printArray(n, a, "a");
        }
    }

    private static void printArray(int finish, int[] f, String name) {

        System.out.print(name + "배열 : ");
        for (int j = 0; j < finish; j++) {
            System.out.print(f[j] + " ");
        }
        System.out.println();
    }

    private static int findMax(int[] x) {
        int max = x[0];
        for (int i = 1; i < x.length; i++) {
            if(max<x[i]) max = x[i];
        }
        return max;
    }
}
