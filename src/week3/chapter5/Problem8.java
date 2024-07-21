//package week3.chapter5;
//
//import java.util.Scanner;
//import java.util.Stack;
//
//public class Problem8 {
//
//    static class Info {
//        int n;       // 현재 원반 번호
//        int remain;  // 자기 포함 남은 원반 수
//        int start;   // 시작 기둥
//        int end;     // 목표 기둥
//        int temp;    // 임시 기둥
//
//        public Info(int n, int remain, int start, int end, int temp) {
//            this.n = n;       // 현재 원반 번호
//            this.remain = remain; // 남은 원반 수
//            this.start = start;
//            this.end = end;
//            this.temp = temp;
//        }
//    }
//
//    static String[] pole = {"", "A기둥", "B기둥", "C기둥"};
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("하노이의 탑");
//        System.out.print("원반의 개수 : ");
//        int n = scanner.nextInt();
//
//        hanoi(n, 1, 3, 2);
//    }
//
//    private static void hanoi(int n, int start, int end, int temp) {
//        Stack<Info> stack = new Stack<>();
//        stack.push(new Info(n, n, start, end, temp));
//
//        while (!stack.isEmpty()) {
//            Info now = stack.pop();
//
//            if (now.remain == 1) {
//                // 현재 원반을 옮기는 경우
//                System.out.println("원반[" + now.n + "]을 " + pole[now.start] + "에서 " + pole[now.end] + "으로 옮김");
//            } else {
//                // n-1 원반을 start에서 temp로 이동
//                while(true) {
//                    if(now.remain == 1) break;
//                    stack.push(new Info(now.n - 1, now.remain - 1, now.start, now.temp, now.end));
//                }
//
//                // n번 원반을 start에서 end로 이동
//                stack.push(new Info(now.n, 1, now.start, now.end, now.temp));
//                // n-1 원반을 temp에서 end로 이동
//                stack.push(new Info(now.n - 1, now.remain - 1, now.temp, now.end, now.start));
//            }
//        }
//    }
//}
