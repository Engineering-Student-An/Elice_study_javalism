package week2.chapter3;

import java.util.Scanner;

public class problem2 {
    public static void main(String[] args) {

        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = stdIn.nextInt();
        int[] x = new int[num];                        // 요솟수가 num + 1인 배열

        for (int i = 0; i < num; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        System.out.print("검색 값 : ");                    // 키값을 읽력받음
        int ky = stdIn.nextInt();

        int index = printScanning(x, ky);
        if(index != -1){
            System.out.println("그 값은 x[" + index + "]에 있습니다.");
        } else {
            System.out.println("그 값은 존재하지 않습니다.");
        }

    }

    public static int printScanning(int[] arr, int key) {
        System.out.print("   |");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%3d", i);
        }
        System.out.println("\n---+-----------------------");

        for (int i = 0; i < arr.length; i++) {
            System.out.print("   |");
            for (int j = 0; j < 3*(i+1)-1; j++) {
                System.out.print(" ");
            }
            System.out.println("*");

            System.out.printf("%3d|",i);
            for (int j = 0; j < arr.length; j++) {
                System.out.printf("%3d", arr[j]);
            }
            System.out.println();
            if(arr[i] == key) return i;
        }

        return -1;
    }
}
