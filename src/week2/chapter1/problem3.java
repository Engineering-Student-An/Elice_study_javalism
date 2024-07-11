package week2.chapter1;

import java.util.Arrays;

public class problem3 {
    public static void main(String[] args) {
        System.out.println(min4(5,3,1, -10));
    }
    public static int min4(int a, int b, int c, int d) {
        Integer[] arr = {a, b, c, d};
        Arrays.sort(arr);
        return arr[0];
    }
}
