package week2.chapter4.problem3;

import week2.chapter4.problem1.IntStack;
import week2.chapter4.problem2.Stack;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        TwoTopIntStack s = new TwoTopIntStack(64);

        while (true) {
            System.out.println(); // 메뉴 구분을 위한 빈 행 추가
            System.out.printf("현재 데이터 개수: %d, %d / %d\n", s.size1(), s.size2(), s.getCapacity());
            System.out.println("스택A : (1)푸시　(2)팝　(3)피크　(4)덤프　(5)클리어 (6)indexOf (7)isEmpty (8)isFull");
            System.out.print("스택B : (11)푸시　(12)팝　(13)피크　(14)덤프　(15)클리어 (16)indexOf (17)isEmpty (18)isFull (0)종료 :");

            int menu = stdIn.nextInt();
            if (menu == 0) break;

            int x;
            switch (menu) {
                case 1:                                // 푸시
                    System.out.print("데이터: ");
                    x = stdIn.nextInt();
                    try {
                        s.push1(x);
                    } catch (IntStack.OverflowIntStackException e) {
                        System.out.println("스택이 가득 찼습니다.");
                    }
                    break;

                case 2:                                // 팝
                    try {
                        x = s.pop1();
                        System.out.println("팝한 데이터는 " + x + "입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어있습니다.");
                    }
                    break;

                case 3:                                // 피크
                    try {
                        x = s.peek1();
                        System.out.println("피크한 데이터는 " + x + "입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어있습니다.");
                    }
                    break;

                case 4:                                // 덤프
                    s.dump1();
                    break;

                case 5:
                    s.clear1();
                    break;

                case 6:
                    try {
                        System.out.println("검색하고 싶은 데이터를 입력하세요: ");
                        int data = stdIn.nextInt();
                        int index = s.indexOf1(data);
                        if(index == -1) {
                            System.out.println("해당 데이터는 스택에 존재하지 않습니다.");
                        } else {
                            System.out.println("해당 데이터는 " + index + "에 존재합니다.");
                        }
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어있습니다.");
                    }
                    break;

                case 7:
                    System.out.println("s.isEmpty() = " + s.isEmpty1());
                    break;

                case 8:
                    System.out.println("s.isFull() = " + s.isFull());
                    break;



                case 11:                                // 푸시
                    System.out.print("데이터: ");
                    x = stdIn.nextInt();
                    try {
                        s.push2(x);
                    } catch (IntStack.OverflowIntStackException e) {
                        System.out.println("스택이 가득 찼습니다.");
                    }
                    break;

                case 12:                                // 팝
                    try {
                        x = s.pop2();
                        System.out.println("팝한 데이터는 " + x + "입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어있습니다.");
                    }
                    break;

                case 13:                                // 피크
                    try {
                        x = s.peek2();
                        System.out.println("피크한 데이터는 " + x + "입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어있습니다.");
                    }
                    break;

                case 14:                                // 덤프
                    s.dump2();
                    break;

                case 15:
                    s.clear2();
                    break;

                case 16:
                    try {
                        System.out.println("검색하고 싶은 데이터를 입력하세요: ");
                        int data = stdIn.nextInt();
                        int index = s.indexOf2(data);
                        if(index == -1) {
                            System.out.println("해당 데이터는 스택에 존재하지 않습니다.");
                        } else {
                            System.out.println("해당 데이터는 " + index + "에 존재합니다.");
                        }
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어있습니다.");
                    }
                    break;

                case 17:
                    System.out.println("s.isEmpty() = " + s.isEmpty2());
                    break;

                case 18:
                    System.out.println("s.isFull() = " + s.isFull());
                    break;
            }
        }
    }
}
