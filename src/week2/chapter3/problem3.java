package week2.chapter3;

import java.util.Arrays;
import java.util.Scanner;

public class problem3 {
    public static void main(String[] args) {

        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int n = stdIn.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("a[" + i + "] : ");
            a[i] = stdIn.nextInt();
        }

        System.out.print("검색 값 : ");                    // 키값을 읽력받음
        int key = stdIn.nextInt();
        int[] idx = new int[n];
        // idx 배열에 -1로 초기화
        Arrays.fill(idx, -1);

        System.out.println("searchIdx(a, n, key, idx) = " + searchIdx(a, n, key, idx));
        System.out.print("idx : [");
        for (int i : idx) {
            if(i!=-1) System.out.print(i + " ");
        }
        System.out.println("]");
    }

    static int searchIdx(int[] a, int n, int key, int[] idx) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(a[i] == key) {
                idx[count ++] = i;
            }
        }
        return count;
    }
}
