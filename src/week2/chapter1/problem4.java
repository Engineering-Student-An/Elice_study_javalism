package week2.chapter1;

public class problem4 {

    public static void main(String[] args) {

        System.out.println("median3(3,2,1) = " + median3(3, 2, 1));        // [A] a＞b＞c
        System.out.println("median3(3,2,2) = " + median3(3, 2, 2));        // [B] a＞b＝c
        System.out.println("median3(3,1,2) = " + median3(3, 1, 2));        // [C] a＞c＞b
        System.out.println("median3(3,2,3) = " + median3(3, 2, 3));        // [D] a＝c＞b
        System.out.println("median3(2,1,3) = " + median3(2, 1, 3));        // [E] c＞a＞b
        System.out.println("median3(3,3,2) = " + median3(3, 3, 2));        // [F] a＝b＞c
        System.out.println("median3(3,3,3) = " + median3(3, 3, 3));        // [G] a＝b＝c
        System.out.println("median3(2,2,3) = " + median3(2, 2, 3));        // [H] c＞a＝b
        System.out.println("median3(2,3,1) = " + median3(2, 3, 1));        // [I} b＞a＞c
        System.out.println("median3(2,3,2) = " + median3(2, 3, 2));        // [J] b＞a＝c
        System.out.println("median3(1,3,2) = " + median3(1, 3, 2));        // [K] b＞c＞a
        System.out.println("median3(2,3,3) = " + median3(2, 3, 3));        // [L] b＝c＞a
        System.out.println("median3(1,2,3) = " + median3(1, 2, 3));        // [M] c＞b＞a
    }

    public static int median3(int a, int b, int c) {
        if(a>=b) {
            if(b>=c) {
                return b;
            } else if(c>=a){
                return a;
            } else {
                return c;
            }
        }
        else if(a>c) {
            return a;
        } else if(b>c) {
            return c;
        } else {
            return b;
        }
    }
}
