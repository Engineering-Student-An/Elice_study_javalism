package week2.chapter4;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeEx {
    public static void main(String[] args) {

        Deque<Integer> integerDeque = new ArrayDeque<>();
        Deque<String> stringDeque = new ArrayDeque<>();
        Deque<Boolean> booleanDeque = new ArrayDeque<>();

        integerDeque.add(1);
        integerDeque.offer(2);
        System.out.println("integerDeque = " + integerDeque);

        integerDeque.addLast(3);
        integerDeque.addFirst(4);
        System.out.println("integerDeque = " + integerDeque);
    }
}
