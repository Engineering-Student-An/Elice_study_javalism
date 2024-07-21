package week3.chapter5;

import java.util.Stack;

public class Problem10 {
    static int count = 0;
    static boolean[] flag_a = new boolean[8];     // 각 행에 퀸이 이미 배치되었는가?
    static boolean[] flag_b = new boolean[15];    // 대각선 ↙에 퀸이 이미 배치되었는가?
    static boolean[] flag_c = new boolean[15];    // 대각선 ↘에 퀸이 이미 배치되었는가?
    static int[] pos = new int[8];                // 각 열의 퀸의 위치

    //--- 각 열의 퀸의 위치를 출력 ---//
    static void print() {
        count ++;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (pos[j] == i) System.out.print("■");
                else System.out.print("□");
            }
            System.out.println();
        }
        System.out.println();
    }

    //--- 비재귀적으로 퀸을 배치 ---//
    static void set() {
        Stack<Integer> stack = new Stack<>();
        int i = 0; // 현재 열
        int j = 0; // 현재 행

        while (i >= 0) {
            // 행을 찾기
            while (j < 8) {
                if (!flag_a[j] && !flag_b[i + j] && !flag_c[i - j + 7]) { // 가로, 대각선 (2개) 확인
                    pos[i] = j; // 퀸을 j행에 배치
                    if (i == 7) { // 모든 열에 배치한 경우
                        print();
                    } else {
                        // 다음 열로 이동
                        flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = true; // 퀸 배치
                        stack.push(i); // 현재 열을 스택에 저장
                        i++; // 다음 열로 이동
                        j = 0; // 행 초기화
                        break;
                    }
                }
                j++;
            }

            // 더 이상 배치할 수 없는 경우
            if (j == 8) {
                if (stack.isEmpty()) {
                    break; // 더이상 경우 존재 x => 끝
                }
                // 이전 열로 돌아가기
                i = stack.pop(); // 스택에서 열 가져옴
                j = pos[i] + 1; // 다음 행으로 이동
                // 퀸 제거
                flag_a[pos[i]] = flag_b[i + pos[i]] = flag_c[i - pos[i] + 7] = false;
            }
        }
    }

    public static void main(String[] args) {
        set();

        System.out.println("count = " + count);
    }
}
