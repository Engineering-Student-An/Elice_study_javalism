package week2.chapter1;

import java.util.Scanner;

public class problem7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.println("gaussianSum(n) = " + gaussianSum(n));
        
    }
    
    public static int gaussianSum(int n) {
        return (1+n)*n/2;
    }
}
