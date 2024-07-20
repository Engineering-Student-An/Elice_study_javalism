package week3.chapter5;

import java.util.Scanner;

public class Problem7 {

    static String[] pole = {"", "A기둥", "B기둥", "C기둥"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("하노이의 탑");
        System.out.print("원반의 개수 : ");
        int n = scanner.nextInt();

        hanoi(n, 1, 3, 2);
    }

    // 매개변수 4개 => 원반 번호, 시작, 목표, 중간 순
    private static void hanoi(int n, int start, int end, int temp) {
        if(n<=1) {
            System.out.println("원반[" + n + "]을 " + pole[start] + "에서 " + pole[end] + "으로 옮김");
            return;
        }

        // 1. 그룹을 시작 -> 중간
        hanoi(n-1, start, temp, end);
        // 2. 그룹 제외 바닥 원반을 시작 -> 목표
        System.out.println("원반[" + n + "]을 " + pole[start] + "에서 " + pole[end] + "으로 옮김");
        // 3. 그룹을 중간 -> 목표
        hanoi(n-1, temp, end, start);
    }
}
