package week2.chapter5;

import java.util.Arrays;
import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("배열의 요소 개수: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // i와 i+1 두수의 최대공약수 구해서 arr[i+1]에 넣음 => 최종결과 : arr[n-1]
        // ex. [2, 16, 4, 30]
        // [2(x), 2, 4, 30]
        // [2(x), 2(x), 2, 30]
        // [2(x), 2(x), 2(x), 2]
        for (int i = 0; i < n - 1; i++) {
            arr[i+1] = gcd(arr[i], arr[i+1]);
        }

        System.out.println("배열의 모든 요소의 최대공약수: " + arr[n - 1]);
    }

    private static int gcd(int x, int y) {
        while(y !=0) {
            int temp = x;
            x = y;
            y = temp% y;
        }

        return x;
    }
}
