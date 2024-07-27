package week4.chapter6;

import java.util.Scanner;

// 답지 이해 식
public class Problem16 {

    static void swap(int[] a, int i, int j) {
        int t = a[i]; a[i] = a[j]; a[j] = t;
    }

    //--- n개의 스페이스(공백문자)를 출력하는 메서드 ---//
    static void dispSpace(int n) {
        for (int i = 0; i < n; i++)
            System.out.print(' '); // n만큼의 공백을 출력
    }

    //--- 힙을 출력하는 메서드 ---//
    static void dispHeap(int a[], int n) {
        int i = n;  // 배열의 크기 설정
        int height = 1;  // 트리의 높이 초기화
        while ((i >>= 1) > 0) // 완전 이진 트리의 높이 계산
            height++;
        i = 0;  // 인덱스 초기화
        int w = 1;  // 현재 출력할 너비 초기화
        Loop : { // 레이블을 붙인 블록
            for (int level = 0; level < height; level++) { // 각 레벨에 대해
                dispSpace((int) (Math.pow(2, height - level) - 2)); // 레벨에 맞는 공백 출력
                for (int k = 0; k < w; k++) { // 현재 너비만큼 출력
                    System.out.printf("%02d", a[i++]); // 배열 요소 출력
                    if (i >= n) break Loop; // 배열의 끝에 도달하면 종료
                    if (k < w - 1)
                        dispSpace((int) (Math.pow(2, height - level + 1) - 2)); // 공백 출력
                }
                System.out.println(); // 다음 줄로 이동

                dispSpace((int) (Math.pow(2, height - level) - 3)); // 트리 구조를 위한 공백 출력
                for (int k = 0; k < w; k++) { // 자식 노드의 선 출력
                    if (2 * k + i < n) System.out.print(" /"); // 왼쪽 자식
                    if (2 * k + i + 1 < n) System.out.print("＼"); // 오른쪽 자식
                    if (k < w - 1)
                        dispSpace((int) (Math.pow(2, height - level + 1) - 4)); // 공백 출력
                }
                System.out.println(); // 다음 줄로 이동
                w *= 2; // 다음 레벨의 너비를 두 배로 증가
            }
        }
        System.out.println(); // 추가 줄바꿈
        System.out.println(); // 추가 줄바꿈
    }

    //--- a[left]~a[right]을 힙으로 만드는 메서드 ---//
    static void downHeap(int[] a, int left, int right) {
        int temp = a[left]; // 루트 노드 저장
        int child; // 큰 쪽의 자식
        int parent; // 부모 인덱스

        for (parent = left; parent < (right + 1) / 2; parent = child) {
            int cl = parent * 2 + 1; // 왼쪽 자식의 인덱스
            int cr = cl + 1; // 오른쪽 자식의 인덱스
            child = (cr <= right && a[cr] > a[cl]) ? cr : cl; // 큰 자식 선택
            if (temp >= a[child]) // 부모가 자식보다 크면 종료
                break;
            a[parent] = a[child]; // 부모를 자식으로 이동
        }
        a[parent] = temp; // 최종적으로 자리를 바꿈
    }

    //--- 힙 정렬 메서드 ---//
    static void heapSort(int[] a, int n) {
        for (int i = (n - 1) / 2; i >= 0; i--) { // 배열을 힙으로 변환
            dispHeap(a, n); // 현재 힙 상태 출력
            downHeap(a, i, n - 1); // 힙 구조 유지
        }

        for (int i = n - 1; i > 0; i--) {
            swap(a, 0, i); // 최대 요소와 마지막 요소 교환
            dispHeap(a, n); // 현재 힙 상태 출력
            downHeap(a, 0, i - 1); // 힙 구조 유지
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("힙 정렬");
        System.out.print("요솟수 : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        heapSort(x, nx); // 입력된 배열을 힙 정렬

        System.out.println("오름차순으로 정렬하였습니다.");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "]＝" + x[i]);
    }
}
