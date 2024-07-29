package week4.chapter7;

import java.util.Scanner;

public class Problem1 {

    static int ptc = -1;
    static int bfMatch(String txt, String pat) {
        int pt = 0;        // 텍스트 커서
        int pp = 0;        // 패턴 커서

        int count = 0;
        int ptCount = 0;
        // 검사하는 텍스트 커서가 텍스트의 끝에 도달하지 x
        // 패턴 커서가 패턴의 끝에 도달하지 x
        while (pt != txt.length() && pp != pat.length()) {

            count ++;

            printInfo(txt, pat, pt, ptCount, (txt.charAt(pt) == pat.charAt(pp)));
            // 텍스트 커서가 나타내는 문자와 패턴 커서가 나타내는 문자가 동일한 경우 -> 둘다 한칸씩 증가
            if (txt.charAt(pt) == pat.charAt(pp)) {
                pt++;
                pp++;
            }
            // 문자가 다른 경우 -> 텍스트 커서 = 원래 위치에서 1증가, 패턴 커서 = 0 (처음부터)
            else {
                pt = pt - pp + 1;
                pp = 0;
                ptCount ++;
            }
        }

        System.out.println("비교를 " + count + "회 했습니다.");

        if (pp == pat.length())        // 검색 성공
            return pt - pp; // 텍스트 내에서 패턴이 시작하는 인덱스 반환
        return -1;                     // 검색 실패 -> -1 반환
    }

    private static void printInfo(String txt, String pat, int pt, int ptCount, boolean isEqual) {

        // 패턴 옮길 때마다 검사하는 텍스트의 첫번째 문자 인덱스 출력
        if(ptCount != ptc) {
            System.out.printf("%-4d", ptCount);
            ptc = ptCount;
        } else {
            System.out.print("    ");
        }

        // 텍스트 출력
        System.out.println(txt);

        // +, | 출력
        System.out.print("    ");
        System.out.print(" ".repeat(pt));
        System.out.println((isEqual) ? "+" : "|");

        // 패턴 출력
        System.out.print("    ");
        System.out.print(" ".repeat(ptc));
        System.out.println(pat);

        // 한 줄 띄움
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("텍스트: ");
        String s1 = stdIn.next();                     // 텍스트용 문자열

        System.out.print("패  턴: ");
        String s2 = stdIn.next();                     // 패턴용 문자열

        int idx = bfMatch(s1, s2);    // 문자열 s1에서 문자열 s2를 브루트-포스법으로 검색

        if (idx == -1)
            System.out.println("텍스트 안에 패턴이 없습니다.");
        else {
            // 일치하는 문자 바로 앞까지의 문자 개수를 반각 문자로 환산하여 구함
            int len = 0;
            for (int i = 0; i < idx; i++)
                len += s1.substring(i, i + 1).getBytes().length;
            len += s2.length();

            System.out.println((idx + 1) + "번째 문자부터 일치합니다.");
            System.out.println("텍스트: " + s1);
            System.out.printf(String.format("패  턴: %%%ds\n", len), s2);
        }
    }
}
