package week4.chapter6;

// 신체검사 데이터 배열의 정렬

import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;

public class Problem15 {
    //--- 신체검사 데이터 ---//
    static class PhyscData {
        String name;              // 이름
        int    height;            // 키
        double vision;            // 시력

        //--- 생성자(constructor) ---//
        PhyscData(String name, int height, double vision) {
            this.name = name;  this.height = height;  this.vision = vision;
        }

        //--- 신체검사 데이터를 문자열로 반환 --//
        public String toString() {
            return name + " " + height + " " + vision;
        }

        //--- 키의 오름차순용 comparator ---//
        static final Comparator<PhyscData> HEIGHT_ORDER = new HeightOrderComparator();

        private static class HeightOrderComparator implements Comparator<PhyscData> {
            public int compare(PhyscData d1, PhyscData d2) {
                // Integer.compare(), Double.compare() => 앞의 수가 작으면 -1, 같으면 0, 크면 1 반환
                System.out.println("d1.vision = " + d1.vision);
                System.out.println("d2.vision = " + d2.vision);
                System.out.println("Double.compare(d2.vision, d1.vision) = " + Double.compare(d2.vision, d1.vision));
                return Double.compare(d2.vision, d1.vision);
                // 오름차순 : 작은 값 음수, 큰 값 양수 기준을 통해서 정렬
                // 이를 반대로 구현
                // d2의 시력이 작으면 = d1의 시력이 크면 -1 반환 => 내림차순 구현됨
            }
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        PhyscData[] x = {
                new PhyscData("강민하", 162, 0.3),
                new PhyscData("김찬우", 173, 0.7),
                new PhyscData("박준서", 175, 2.0),
                new PhyscData("유서범", 171, 1.5),
                new PhyscData("이수연", 168, 0.4),
                new PhyscData("장경오", 174, 1.2),
                new PhyscData("황지안", 169, 0.8),
        };

        Arrays.sort(x,						    // 배열 x를
                PhyscData.HEIGHT_ORDER      // HEIGHT_ORDER를 사용하여 정렬
        );

        System.out.println("■ 신체검사 리스트 ■");
        System.out.println(" 이름     키  시력");
        System.out.println("------------------");
        for (int i = 0; i < x.length; i++)
            System.out.printf("%-8s%3d%5.1f\n", x[i].name, x[i].height, x[i].vision);
    }
}