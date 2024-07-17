package week2.chapter4.problem6;

import week2.chapter4.problem5.IntQueue;

public class Queue<E>{
    private E[] que;
    private int capacity;
    private int num;
    private int front;
    private int rear;


    public Queue(int maxlen) {
        num = front = rear = 0;
        capacity = maxlen;
        try {
            que = (E[]) new Object[capacity];          // 큐 본체용 배열을 생성
        } catch (OutOfMemoryError e) {        // 생성할 수 없음
            capacity = 0;
        }
    }

    public E enque(E x) throws OverflowQueueException {
        if (num >= capacity)
            throw new OverflowQueueException();            // 큐가 가득 찼음
        que[rear++] = x;
        num++;
        if (rear == capacity)
            rear = 0;
        return x;
    }

    public E deque() throws EmptyQueueException {
        if (num <= 0)
            throw new EmptyQueueException();            // 큐가 비어있음
        E x = que[front++];
        num--;
        if (front == capacity)
            front = 0;
        return x;
    }

    public E peek() throws EmptyQueueException {
        if (num <= 0)
            throw new EmptyQueueException();            // 큐가 비어있음
        return que[front];
    }

    public void clear() {
        num = front = rear = 0;
    }

    public int indexOf(E x) {
        for (int i = 0; i < num; i++) {
            if (que[(i + front) % capacity].equals(x))                // 검색 성공
                return (i + front) % capacity;
        }
        return -1;                            // 검색 실패
    }

    public int getCapacity() {
        return capacity;
    }

    public int size() {
        return num;
    }

    public boolean isEmpty() {
        return num <= 0;
    }

    public boolean isFull() {
        return num >= capacity;
    }

    public void dump() {
        if (num <= 0)
            System.out.println("큐가 비어있습니다.");
        else {
            System.out.print("[");
            for (int i = 0; i < num-1; i++){
                System.out.print(que[(i + front) % capacity] + ", ");
            }

            System.out.println(que[(front+num-1) % capacity] + "]");
        }
    }
}
