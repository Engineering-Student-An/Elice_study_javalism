package week2.chapter2;

import java.time.LocalDate;

public class problem8 {
}

class YMD {
    int y;
    int m;
    int d;

    public YMD(int y, int m, int d) {
        this.y = y;
        this.m = m;
        this.d = d;
    }

    public LocalDate after(int n) {
        LocalDate now = LocalDate.of(y,m,d);

        return now.plusDays(n);
    }

    public LocalDate before(int n) {
        LocalDate now = LocalDate.of(y,m,d);

        return now.minusDays(n);
    }
}
