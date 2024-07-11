package week2.chapter1;

import java.util.Arrays;
import java.util.Collections;

public class problem1 {
    public static void main(String[] args) {
        System.out.println(max4(4,2,3,1));
    }

    public static int max4(int a, int b, int c, int d) {
        Integer[] arr = {a, b, c, d};
        Arrays.sort(arr, Collections.reverseOrder());
        return arr[0];
    }
}
