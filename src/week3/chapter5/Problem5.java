package week3.chapter5;

import java.util.Scanner;

public class Problem5 {

    private static String[] memo;
    private static int countRecur = 0;
    private static int countRecurMemo = 0;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        // 메서드 실행 시간 추가
        long startTime = System.currentTimeMillis();
        recur(n);
        long finishTime = System.currentTimeMillis();

        long recurTime = finishTime - startTime;

        memo = new String[n+2];
        startTime = System.currentTimeMillis();
        recurMemo(n);
        finishTime = System.currentTimeMillis();

        long recurMemoTime = finishTime - startTime;

        System.out.println("countRecur = " + countRecur);
        System.out.println("countRecurMemo = " + countRecurMemo);

        System.out.println("recurTime = " + recurTime);
        System.out.println("recurMemoTime = " + recurMemoTime);
    }

    static void recur(int n) {
        countRecur ++;
        if(n>0) {
            recur(n-1);
            System.out.println(n);
            recur(n-2);
        }
    }

    static void recurMemo(int n) {
        countRecurMemo ++;
        if(memo[n+1] != null) System.out.println(memo[n+1]);
        else {
            if (n > 0) {
                recurMemo(n-1);
                System.out.println(n);
                recurMemo(n-2);
                memo[n+1] = memo[n] + n + "\n" + memo[n-1];
            } else {
                memo[n+1] = "";
            }
        }
    }
}
