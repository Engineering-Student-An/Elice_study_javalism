package week2.chapter4;

import java.util.Stack;

public class StackEx {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        Integer push = stack.push(100);
        System.out.println("push = " + push);
        stack.add(3);
        boolean add = stack.add(4);
        System.out.println("add = " + add);

        Integer pop = stack.pop();
        System.out.println("pop = " + pop);
        System.out.println("stack = " + stack);

        System.out.println("stack.peek() = " + stack.peek());

        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println("!");
        stack.clear();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        stack.push(1);


        int index = stack.indexOf(1);
        System.out.println("index = " + index);

        System.out.println("stack.size() = " + stack.size());

        System.out.println("stack.isEmpty() = " + stack.isEmpty());


    }
}
