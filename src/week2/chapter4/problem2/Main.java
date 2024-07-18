package week2.chapter4.problem2;

import week2.chapter4.problem1.IntStack;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        Stack<String> s = new Stack<>(64);    // 최대 64 개를 푸시할 수 있는 스택

        while (true) {
            System.out.println(); // 메뉴 구분을 위한 빈 행 추가
            System.out.printf("현재 데이터 개수: %d / %d\n", s.size(), s.getCapacity());
            System.out.print("(1)푸시　(2)팝　(3)피크　(4)덤프　(5)클리어 (6)indexOf (7)isEmpty (8)isFull (0)종료: ");

            int menu = stdIn.nextInt();
            if (menu == 0) break;

            String x;
            switch (menu) {
                case 1:                                // 푸시
                    System.out.print("데이터: ");
                    x = stdIn.next();
                    try {
                        s.push(x);
                    } catch (Stack.OverflowGenericStackException e) {
                        System.out.println("스택이 가득 찼습니다.");
                    }
                    break;

                case 2:                                // 팝
                    try {
                        x = s.pop();
                        System.out.println("팝한 데이터는 " + x + "입니다.");
                    } catch (Stack.EmptyGenericStackException e) {
                        System.out.println("스택이 비어있습니다.");
                    }
                    break;

                case 3:                                // 피크
                    try {
                        x = s.peek();
                        System.out.println("피크한 데이터는 " + x + "입니다.");
                    } catch (Stack.EmptyGenericStackException e) {
                        System.out.println("스택이 비어있습니다.");
                    }
                    break;

                case 4:                                // 덤프
                    s.dump();
                    break;

                case 5:
                    s.clear();
                    break;

                case 6:
                    try {
                        System.out.println("검색하고 싶은 데이터를 입력하세요: ");
                        String data = stdIn.next();
                        int index = s.indexOf(data);
                        if(index == -1) {
                            System.out.println("해당 데이터는 스택에 존재하지 않습니다.");
                        } else {
                            System.out.println("해당 데이터는 " + index + "에 존재합니다.");
                        }
                    } catch (Stack.EmptyGenericStackException e) {
                        System.out.println("스택이 비어있습니다.");
                    }
                    break;

                case 7:
                    System.out.println("s.isEmpty() = " + s.isEmpty());
                    break;

                case 8:
                    System.out.println("s.isFull() = " + s.isFull());
                    break;
            }
        }
    }
}
