package week2.chapter3;

public class problem5 {
    public static void main(String[] args) {

        int[] arr = {1, 3, 5, 7, 7, 7, 7, 8, 8, 9, 9};
        int n = 11;
        int key = 7;
        System.out.println("binSearchX(arr, n, key) = " + binSearchX(arr, n, key));
    }

    private static int binSearchX(int[] arr, int n, int key) {
        int start = 0;
        int end = n-1;
        int middle = 0;
        while(start <= end) {
            middle = (start+end) / 2;
            if(arr[middle] == key) {
                int i;
                for (i = middle; i >= 0; i--) {
                    if(arr[i] != key) return (i+1);
                }

            } else if(arr[middle] > key) {
                end = middle-1;
            } else if(arr[middle] < key) {
                start = middle+1;
            }
        }

        return -1;
    }
}
