package week2.chapter3;

import java.util.Scanner;

public class problem4 {
    public static void main(String[] args) {

        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int n = stdIn.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("a[" + i + "] : ");
            a[i] = stdIn.nextInt();
        }

        System.out.print("검색 값 : ");                    // 키값을 읽력받음
        int key = stdIn.nextInt();

        int index = printScanning(a, key);
        if(index != -1) {
            System.out.println(key + "는 a[" + index + "]에 있습니다.");
        } else {
            System.out.println(key + "는 존재하지 않습니다.");
        }
    }

    public static int printScanning(int[] arr, int key) {
        System.out.print("   |");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%3d", i);
        }
        System.out.println("\n---+-----------------------");

        int start = 0;
        int end = arr.length-1;
        int middle;
        while(start<=end) {
            middle = (start+end) / 2;
            System.out.print("   |");
            for (int i = 0; i < arr.length; i++) {
                if (i == middle) {
                    System.out.print("  + ");
                }else if (i == start) {
                    System.out.print(" <-");
                } else if (i == end) {
                    System.out.print(" ->");
                } else {
                    System.out.print("   ");
                }
            }

            System.out.printf("\n%3d|", middle);
            for (int i : arr) {
                System.out.printf("%3d", i);
            }
            System.out.println();
            if(arr[middle] < key) {
                start = middle + 1;
            } else if(arr[middle] > key) {
                end = middle - 1;
            } else if(arr[middle] == key) {
                return middle;
            }
            System.out.println("   |");
        }
        return -1;
    }
}
