package week2.chapter4.problem7;

public class IntDeque {
    private int deque[];
    private int capacity;
    private int num;

    public int front;
    public int rear;

    public class EmptyIntDequeException extends RuntimeException {
        public EmptyIntDequeException() {
        }
    }

    public class OverflowIntDequeException extends RuntimeException {
        public OverflowIntDequeException() {
        }
    }

    public IntDeque(int n) {
        num = front = rear = 0;
        capacity = n;
        deque = new int[capacity];
    }

    public int enqueFirst(int data) throws OverflowIntDequeException {
        if(num >= capacity) {
            throw new OverflowIntDequeException();
        }
        num ++;

        if(--front < 0) {
            front = capacity - 1;
        }
        deque[front] = data;
        return data;
    }

    public int enqueLast(int data) throws OverflowIntDequeException {
        if(num >= capacity) {
            throw new OverflowIntDequeException();
        }
        num ++;

        deque[rear++] = data;
        if(rear == capacity) rear = 0;
        return data;
    }

    public int dequeFirst() throws EmptyIntDequeException {
        if(num == 0) {
            throw new EmptyIntDequeException();
        }
        num --;
        int result = deque[front];
        if(++ front == capacity) {
            front = 0;
        }
        return result;
    }

    public int dequeLast() throws EmptyIntDequeException {
        if(num == 0) {
            throw new EmptyIntDequeException();
        }
        num --;
        if(--rear < 0) rear = capacity-1;
        return deque[rear];
    }

    public int peekFirst() throws EmptyIntDequeException{
        if(num == 0) {
            throw new EmptyIntDequeException();
        }
        return deque[front];
    }

    public int peekLast() throws EmptyIntDequeException {
        if(num == 0) {
            throw new EmptyIntDequeException();
        }
        if(rear == 0) {
            return deque[capacity-1];
        }
        return deque[rear-1];
    }

    public void dump() {
        System.out.print("[");
        for (int i = 0; i < num-1; i++) {
            System.out.print(deque[(front+i) % capacity] + ", ");
        }
        System.out.println(deque[(front+num-1) % capacity] + "]");
    }

    public int search(int data) {
        for (int i = 0; i < num; i++) {
            if(deque[(i+front) % capacity] == data) return (i+1);
        }
        return 0;
    }

    public int indexOf(int data) {
        for (int i = 0; i < num; i++) {
            if(deque[(i+front) % capacity] == data) return (i+front) % capacity;
        }
        return -1;
    }
}
