package week4.chapter6.problem12;// 퀵 정렬(비재귀 버전)

import week2.chapter4.problem1.IntStack;

import java.util.Scanner;

class QuickSort2 {
    //--- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];  a[idx1] = a[idx2];  a[idx2] = t;
    }

    //--- 퀵 정렬(비재귀 버전)---//
    static void quickSort(int[] a, int left, int right) {
        IntStack lstack = new IntStack(right - left + 1);
        IntStack rstack = new IntStack(right - left + 1);

        lstack.push(left);
        rstack.push(right);

        while (lstack.isEmpty() != true) {
            int pl = left  = lstack.pop();        // 왼쪽 커서
            int pr = right = rstack.pop();        // 오른쪽 커서
            int x = a[(left + right) / 2];        // 피벗은 가운데 요소

            System.out.printf("a[%d] ~ a[%d] 처리\n", left, right);
            do {
                while (a[pl] < x) pl++;
                while (a[pr] > x) pr--;
                if (pl <= pr)
                    swap(a, pl++, pr--);
            } while (pl <= pr);


            // 왼쪽 그룹이 더 작은 그룹
            if(pr - left < right - pl) {
                if (pl < right) {
                    lstack.push(pl);             // 오른쪽 그룹 범위의
                    rstack.push(right);          // 인덱스를 푸시 (오른쪽이 더 크니까 먼저 푸시)
                }
                if (left < pr) {
                    lstack.push(left);           // 왼쪽 그룹 범위의
                    rstack.push(pr);             // 인덱스를 푸시 (왼쪽은 작으니까 나중에 푸시 => 먼저 나눔)
                }
            } else {  // 오른쪽 그룹이 더 작거나 같은 그룹
                if (left < pr) {
                    lstack.push(left);           // 왼쪽 그룹 범위의
                    rstack.push(pr);             // 인덱스를 푸시 (왼쪽이 더 크니까 먼저 푸시)
                }
                if (pl < right) {
                    lstack.push(pl);             // 오른쪽 그룹 범위의
                    rstack.push(right);          // 인덱스를 푸시 (오른쪽은 작으니까 나중에 푸시 => 먼저 나눔)
                }
            }

            // 답지
//            if (pr - left < right - pl) {
//                int temp;
//                temp = left;  left  = pl; pl = temp;
//                temp = right; right = pr; pr = temp;
//            }
//            if (left < pr) {
//                lstack.push(left);			// 왼쪽 그룹 범위의
//                rstack.push(pr);				// 인덱스를 푸시
//            }
//            if (pl < right) {
//                lstack.push(pl);				// 오른쪽 그룹 범위의
//                rstack.push(right);			// 인덱스를 푸시
//            }
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("퀵 정렬");
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
