package week4.chapter6;

import java.util.Scanner;

public class Problem18 {
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
        int min = findMin(x);
        countingSort(x, nx, min, max);


        System.out.println("오름차순으로 정렬하였습니다.");
        for (int i : x) {
            System.out.print(i + " ");
        }
    }

    private static void countingSort(int[] a, int n, int min, int max) {

        int[] f = new int[max-min+1];
        int[] b = new int[n];

        // 1. 도수분포표
        for (int i = 0; i < n; i++) f[a[i]-min] ++;
        // 2. 누적 도수분포표
        for (int i = 1; i <= max-min; i++) f[i] += f[i-1];
        // 3. 목표 배열
        for (int i = n-1; i >= 0; i--) b[--f[a[i]-min]] = a[i];
        // 4. 배열 복사
        for (int i = 0; i < n; i++) a[i] = b[i];
    }

    private static int findMax(int[] x) {
        int max = x[0];
        for (int i = 1; i < x.length; i++) {
            if(max<x[i]) max = x[i];
        }
        return max;
    }

    private static int findMin(int[] x) {
        int min = x[0];
        for (int i = 1; i < x.length; i++) {
            if(min>x[i]) min = x[i];
        }
        return min;
    }
}

