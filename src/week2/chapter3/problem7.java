package week2.chapter3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class problem7 {

    static class PhyscData {
        private String name;
        private int height;
        private double vision;

        public PhyscData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        @Override
        public String toString() {
            return "PhyscData{" +
                    "name='" + name + '\'' +
                    ", height=" + height +
                    ", vision=" + vision +
                    '}';
        }


       // 1. Comparator<T> implements 하는 클래스 선언
        private static class VisionComparator implements Comparator<PhyscData> {
            @Override
            public int compare(PhyscData o1, PhyscData o2) {
//                if(o1.vision < o2.vision) return 1;
//                else if(o1.vision == o2.vision) return 0;
//                else return -1;

                return Double.compare(o2.vision, o1.vision);
            }
        }

        // 2. 그 클래스의 인스턴스 생성
        public static final Comparator<PhyscData> VISION_ORDER_REVERSE = new VisionComparator();

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhyscData[] x = {
                new PhyscData("강민하", 162, 0.3),
                new PhyscData("이수연", 168, 0.4),
                new PhyscData("황지안", 169, 0.8),
                new PhyscData("유서범", 171, 1.5),
                new PhyscData("김찬우", 173, 0.7),
                new PhyscData("장경오", 174, 1.2),
                new PhyscData("박준서", 175, 2.0)
        };

        // 시력의 내림차순으로 정렬 코드 추가!!
        Arrays.sort(x, PhyscData.VISION_ORDER_REVERSE);

        System.out.print("시력이 몇인 사람을 찾고 있나요?: ");
        double vision = scanner.nextDouble();
        int idx = Arrays.binarySearch(x, new PhyscData("", 0, vision), PhyscData.VISION_ORDER_REVERSE);

        if (idx < 0){
            System.out.println("그 값의 요소가 없습니다.");
            System.out.println("idx = " + idx);
        }
        else {
            System.out.println("그 값은 x[" + idx + "]에 있습니다.");
            System.out.println("찾은 데이터: " + x[idx]);
        }
    }
}
