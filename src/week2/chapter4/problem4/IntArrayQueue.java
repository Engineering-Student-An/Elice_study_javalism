package week2.chapter4.problem4;

import week2.chapter4.problem1.IntStack;

public class IntArrayQueue {
    private int[] que;
    private int capacity;
    private int num;


    public class EmptyIntQueueException extends RuntimeException {
        public EmptyIntQueueException() {}
    }

    public class OverflowIntQueueException extends RuntimeException {
        public OverflowIntQueueException() {}
    }

    public IntArrayQueue(int maxlen) {
        capacity = maxlen;
        num = 0;
        que = new int[capacity];
    }

    // 1. enqueue
    public int enque(int data) throws OverflowIntQueueException {
        if(num >= capacity) {
            throw new OverflowIntQueueException();
        }
        que[num++] = data;
        return data;
    }

    // 2. dequeue
    public int deque() throws EmptyIntQueueException {
        if(num <= 0) {
            throw new EmptyIntQueueException();
        }
        int temp = que[0];
        for (int i = 1; i < num; i++) {
            que[i-1] = que[i];
        }
        num--;
        return temp;
    }

    // 3, peek
    public int peek() throws EmptyIntQueueException {
        if(num <= 0) {
            throw new EmptyIntQueueException();
        }
        return que[0];
    }

    // 4. clear
    public void clear() {
        num = 0;
    }

    // 5. indexOf
    public int indexOf(int data) {
        for (int i = 0; i < num; i++) {
            if(que[i] == data) {
                return i;
            }
        }
        return -1;
    }

    // 6. getCapacity
    public int getCapacity() {
        return capacity;
    }

    // 7. size
    public int size() {
        return num;
    }

    //8. isEmpty
    public boolean isEmpty() {
        return num==0;
    }

    // 9. isFull
    public boolean isFull() {
        return num==capacity;
    }

    // 10. dump
    public void dump() {
        System.out.print("[");
        for (int i = 0; i < num-1; i++) {
            System.out.print(que[i] + ", ");
        }
        System.out.println(que[num-1] + "]");
    }
}
