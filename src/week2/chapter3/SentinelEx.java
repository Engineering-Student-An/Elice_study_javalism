package week2.chapter3;

public class SentinelEx {
    public static void main(String[] args) {

        int[] arr = {5,3,1,2,4, 0};
        int n = 5;
        int key = 7;

        arr[n] = key;

        int i;
        for (i = 0; i <= n; i++) {
            if(arr[i] == key) break;
        }

        System.out.println(i);
    }
}
