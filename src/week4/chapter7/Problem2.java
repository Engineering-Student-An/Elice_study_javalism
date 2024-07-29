package week4.chapter7;

import java.util.Scanner;

public class Problem2 {

    static int bfMatchLast(String txt, String pat) {
        int pt = txt.length()-1;
        int pp = pat.length()-1;

        int count = 0;
        // 검사하는 텍스트 커서가 텍스트의 앞에 도달하지 x
        // 패턴 커서가 패턴의 앞에 도달하지 x
        while (pt != -1 && pp != -1) {

            count ++;
            // 텍스트 커서가 나타내는 문자와 패턴 커서가 나타내는 문자가 동일한 경우 -> 둘다 한칸씩 rkath
            if (txt.charAt(pt) == pat.charAt(pp)) {
                pt--;
                pp--;
            }
            // 문자가 다른 경우 -> 텍스트 커서 = 원래 위치에서 1감소, 패턴 커서 = 맨 뒤 (뒤부터)
            else {
                pt = pt + (pat.length()-1-pp) - 1;
                pp = pat.length()-1;
            }
        }

        System.out.println("비교를 " + count + "회 했습니다.");

        if (pp == -1)        // 검색 성공
            return pt+1; // 텍스트 내에서 패턴이 시작하는 인덱스 반환
        return -1;                     // 검색 실패 -> -1 반환
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("텍스트: ");
        String s1 = stdIn.next();                     // 텍스트용 문자열

        System.out.print("패  턴: ");
        String s2 = stdIn.next();                     // 패턴용 문자열

        int idx = bfMatchLast(s1, s2);    // 문자열 s1에서 문자열 s2를 브루트-포스법으로 검색

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
