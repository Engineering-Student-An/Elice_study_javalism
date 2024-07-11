package week2.chapter1;

import java.util.Arrays;
import java.util.Collections;

public class problem2 {
    public static void main(String[] args) {
        System.out.println(min3(5,3,1));
    }
    public static int min3(int a, int b, int c) {
        Integer[] arr = {a, b, c};
        Arrays.sort(arr);
        return arr[0];
    }
}
