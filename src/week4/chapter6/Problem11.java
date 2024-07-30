package week4.chapter6;

// 퀵 정렬(비재귀 버전)

import java.util.Scanner;
import java.util.Stack;


public class Problem11 {
    //--- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];  a[idx1] = a[idx2];  a[idx2] = t;
    }

    //--- 퀵 정렬(비재귀 버전)---//
    static void quickSort(int[] a, int left, int right) {

        Stack<Integer> lstack = new Stack<>();
        Stack<Integer> rstack = new Stack<>();
//        IntStack lstack = new IntStack(right - left + 1);
//        IntStack rstack = new IntStack(right - left + 1);

        System.out.printf("a[%d] ~ a[%d] 처리\n", left, right);
        lstack.push(left);
        rstack.push(right);

        System.out.println("(가장 처음)");
        System.out.println("lstack에 " + left + "푸시");
        System.out.println("rstack에 " + right + "푸시");
        System.out.println("====================================");

        while (lstack.isEmpty() != true) {
            int pl = left  = lstack.pop();        // 왼쪽 커서
            System.out.println("lstack에서 " + left + "팝");
            int pr = right = rstack.pop();        // 오른쪽 커서
            System.out.println("rstack에서 " + right + "팝");

            System.out.printf("a[%d] ~ a[%d] 처리\n", left, right);
            int x = a[(left + right) / 2];        // 피벗 = left, right 기준 배열의 가운데 요소

            System.out.println("왼쪽, 오른쪽 그룹 나누기 전");
            System.out.printf("(left : %d, right : %d, pl : %d, pr : %d)\n", left, right, pl, pr);
            for (int i = left; i <= right; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.printf("    (피벗 : %d)\n", x);

            // 피벗 기준으로 요소 교환 (왼쪽, 오른쪽 그룹 나눔)
            do {
                while (a[pl] < x) pl++;
                while (a[pr] > x) pr--;
                if (pl <= pr)
                    swap(a, pl++, pr--);
            } while (pl <= pr);

            System.out.println("왼쪽, 오른쪽 그룹 나눈 이후");
            for (int i = left; i <= right; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.printf("    (피벗 : %d)\n", x);
            System.out.printf("(left : %d, right : %d, pl : %d, pr : %d)\n", left, right, pl, pr);

            if (left < pr) {
                lstack.push(left);           // 왼쪽 그룹 범위의
                rstack.push(pr);             // 인덱스를 푸시
                System.out.println("(왼쪽 그룹의 인덱스를 푸시)");
                System.out.println("lstack에 " + left + "푸시");
                System.out.println("rstack에 " + pr + "푸시");
                System.out.print("왼쪽 그룹 : ");
                for (int i = left; i <= pr; i++) {
                    System.out.print(a[i] + " ");
                }
            }

            System.out.println();
            if (pl < right) {
                lstack.push(pl);             // 오른쪽 그룹 범위의
                rstack.push(right);          // 인덱스를 푸시
                System.out.println("(오른쪽 그룹의 인덱스를 푸시)");
                System.out.println("lstack에 " + pl + "푸시");
                System.out.println("rstack에 " + right + "푸시");
                System.out.print("오른쪽 그룹 : ");
                for (int i = pl; i <= right; i++) {
                    System.out.print(a[i] + " ");
                }
                System.out.println();
            }
            System.out.println("====================================");
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("비재귀적 퀵 정렬");
        System.out.print("요솟수: ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = stdIn.nextInt();
        }

        quickSort(x, 0, nx - 1);            // 배열 x를 퀵정렬

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "]=" + x[i]);
    }
}
