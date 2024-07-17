package week2.chapter4;

import java.util.LinkedList;
import java.util.Queue;

public class QueueEx {
    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        System.out.println("queue.offer(1) = " + queue.offer(2));
        queue.offer(3);

        System.out.println("queue.element() = " + queue.element());
        queue.size();

        queue.clear();


        queue.add(1);

        queue.add(2);

        System.out.println("queue.element() = " + queue.element());

        System.out.println("queue.isEmpty() = " + queue.isEmpty());
    }
}
