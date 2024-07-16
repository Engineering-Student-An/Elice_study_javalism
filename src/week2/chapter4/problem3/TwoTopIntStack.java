package week2.chapter4.problem3;// int형 고정 길이 스택

public class TwoTopIntStack {
    private int[] stk;           // 스택용 배열
    private int capacity;        // 스택의 크기
    private int ptr1;             // 스택 포인터 : 처음부터
    private int ptr2;             // 스택 포인터 : 마지막부터

    //--- 실행시 예외: 스택이 비어있음 ---//
    public class EmptyTwoTopIntStackException extends RuntimeException {
        public EmptyTwoTopIntStackException() { }
    }

    //--- 실행시 예외: 스택이 가득 참 ---//
    public class OverflowTwoTopIntStackException extends RuntimeException {
        public OverflowTwoTopIntStackException() { }
    }

    //--- 생성자(constructor) ---//
    public TwoTopIntStack(int maxlen) {
        ptr1 = 0;
        ptr2 = maxlen - 1;
        capacity = maxlen;
        try {
            stk = new int[capacity];          // 스택 본체용 배열을 생성
        } catch (OutOfMemoryError e) {        // 생성할 수 없음
            capacity = 0;
        }
    }

    
    //--- 스택에 x를 푸시 ---//
    public int push1(int x) throws OverflowTwoTopIntStackException {
        if (ptr1 >= ptr2 + 1 )                                    // 스택이 가득 참
            throw new OverflowTwoTopIntStackException();
        return stk[ptr1++] = x;
    }
    public int push2(int x) throws OverflowTwoTopIntStackException {
        if (ptr1 >= ptr2 + 1 )                                    // 스택이 가득 참
            throw new OverflowTwoTopIntStackException();
        return stk[ptr2--] = x;
    }

    //--- 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄) ---//
    public int pop1() throws EmptyTwoTopIntStackException {
        if (ptr1 <= 0)                                          // 스택이 빔
            throw new EmptyTwoTopIntStackException();
        return stk[--ptr1];
    }
    public int pop2() throws EmptyTwoTopIntStackException {
        if (ptr2 >= capacity - 1)                                          // 스택이 빔
            throw new EmptyTwoTopIntStackException();
        return stk[++ptr2];
    }

    //--- 스택에서 데이터를 피크(peek, 정상에 있는 데이터를 들여다봄) ---//
    public int peek1() throws EmptyTwoTopIntStackException {
        if (ptr1 <= 0)                                        // 스택이 빔
            throw new EmptyTwoTopIntStackException();
        return stk[ptr1 - 1];
    }
    public int peek2() throws EmptyTwoTopIntStackException {
        if (ptr2 >= capacity - 1)                                        // 스택이 빔
            throw new EmptyTwoTopIntStackException();
        return stk[ptr2 + 1];
    }

    //--- 스택을 비움 ---//
    public void clear1() {
        ptr1 = 0;
    }
    public void clear2() {
        ptr2 = capacity - 1;
    }
    //--- 스택에서 x를 찾아 인덱스(없으면 –1)를 반환 ---//
    public int indexOf1(int x) {
        for (int i = ptr1 - 1; i >= 0; i--)     // 꼭대기 쪽부터 선형 검색
            if (stk[i] == x)
                return i;         // 검색 성공
        return -1;                // 검색 실패
    }
    public int indexOf2(int x) {
        for (int i = ptr2 + 1; i < capacity; i++)     // 꼭대기 쪽부터 선형 검색
            if (stk[i] == x)
                return i;         // 검색 성공
        return -1;                // 검색 실패
    }

    //--- 스택의 크기를 반환 ---//
    public int getCapacity() {
        return capacity;
    }

    //--- 스택에 쌓여있는 데이터 갯수를 반환 ---//
    public int size1() {
        return ptr1;
    }
    public int size2() { return capacity - ptr2 - 1; }

    //--- 스택이 비어있는가? ---//
    public boolean isEmpty1() {
        return ptr1 <= 0;
    }
    public boolean isEmpty2() {
        return ptr2 >= capacity - 1;
    }

    //--- 스택이 가득 찼는가? ---//
    public boolean isFull() {
        return ptr1 >= ptr2+1;
    }

    //--- 스택 안의 모든 데이터를 바닥 → 정상 순서로 표시 ---//
    public void dump1() {
        if (ptr1 <= 0)
            System.out.println("스택이 비어있습니다.");
        else {
            for (int i = 0; i < ptr1; i++)
                System.out.print(stk[i] + " ");
            System.out.println();
        }
    }
    public void dump2() {
        if(ptr2 >= capacity - 1)
            System.out.println("스택이 비어있습니다.");
        else {
            for (int i = capacity-1; i > ptr2; i--)
                System.out.print(stk[i] + " ");
            System.out.println();
        }
    }
}