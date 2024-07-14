package week2.chapter3;

public class BinarySearchEx {

    public static void main(String[] args) {

        int[] arr = {0, 10, 20, 30, 40, 50, 60, 70, 80, 90};

        int start = 0;
        int end = arr.length-1;
        int middle;
        int key = 30;

        System.out.println("key = arr[" + binarySearch(start, end, arr, key) + "] 에 존재합니다." );
        System.out.println("100 = arr[" + binarySearch(start, end, arr, 100) + "] 에 존재합니다." );

    }

    private static int binarySearch(int start, int end, int[] arr, int key) {
        int middle;
        while(start <= end) {
            middle = (start + end)/2;
            if(arr[middle] == key) {
                return middle;
            }
            if(arr[middle] > key) {
                end = middle-1;
            } else if(arr[middle] < key) {
                start = middle+1;
            }
        }
        return -1;
    }
}
