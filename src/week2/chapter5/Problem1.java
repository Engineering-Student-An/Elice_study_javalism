package week2.chapter5;

import java.math.BigInteger;
import java.util.Scanner;

// 재귀호출 x 팩토리얼
public class Problem1 {
    public static void main(String[] args) {
        int result = 1;
        Scanner scanner = new Scanner(System.in);
        System.out.print("정수를 입력하세요: ");
        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        System.out.println("result = " + result);

        // 위의 방법으로는 큰 수 담을 수 없음 => BigInteger 사용
        BigInteger resultBig = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            resultBig = resultBig.multiply(BigInteger.valueOf(i));
        }
        System.out.println("resultBig = " + resultBig);
    }
}
