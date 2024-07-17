package week2.chapter4.problem4;

import week2.chapter4.problem1.IntStack;
import week2.chapter4.problem2.Stack;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        IntArrayQueue q = new IntArrayQueue(64);

        while (true) {
            System.out.println(); // 메뉴 구분을 위한 빈 행 추가
            System.out.printf("현재 데이터 개수: %d / %d\n", q.size(), q.getCapacity());
            System.out.print("(1)인큐　(2)디큐　(3)피크　(4)덤프　(5)클리어 (6)indexOf (7)isEmpty (8)isFull (0)종료: ");

            int menu = scanner.nextInt();
            if (menu == 0) break;

            int x;
            switch (menu) {
                case 1:                                // 인큐
                    System.out.print("데이터: ");
                    x = scanner.nextInt();
                    try {
                        q.enque(x);
                    } catch (IntArrayQueue.OverflowIntQueueException e) {
                        System.out.println("큐가 가득 찼습니다.");
                    }
                    break;

                case 2:                                // 디큐
                    try {
                        x = q.deque();
                        System.out.println("디큐한 데이터는 " + x + "입니다.");
                    } catch (IntArrayQueue.EmptyIntQueueException e) {
                        System.out.println("큐가 비어있습니다.");
                    }
                    break;

                case 3:                                // 피크
                    try {
                        x = q.peek();
                        System.out.println("피크한 데이터는 " + x + "입니다.");
                    } catch (IntArrayQueue.EmptyIntQueueException e) {
                        System.out.println("큐가 비어있습니다.");
                    }
                    break;

                case 4:                                // 덤프
                    q.dump();
                    break;

                case 5:
                    q.clear();
                    break;

                case 6:
                    try {
                        System.out.println("검색하고 싶은 데이터를 입력하세요: ");
                        int data = scanner.nextInt();
                        int index = q.indexOf(data);
                        if(index == -1) {
                            System.out.println("해당 데이터는 큐에 존재하지 않습니다.");
                        } else {
                            System.out.println("해당 데이터는 " + index + "에 존재합니다.");
                        }
                    } catch (IntArrayQueue.EmptyIntQueueException e) {
                        System.out.println("큐가 비어있습니다.");
                    }
                    break;

                case 7:
                    System.out.println("q.isEmpty() = " + q.isEmpty());
                    break;

                case 8:
                    System.out.println("q.isFull() = " + q.isFull());
                    break;
            }
        }
    }
}
