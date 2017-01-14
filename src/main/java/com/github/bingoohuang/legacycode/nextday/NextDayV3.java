package com.github.bingoohuang.legacycode.nextday;

/**
 * @author bingoohuang [bingoohuang@gmail.com] Created on 2017/1/14.
 */
public class NextDayV3 {
    int nextdate(int month, int day) {
        if (isLastDayofaYear(day, month)) {
            // 一年中的最后一天，下一天就是1月1日
            day = 1;
            month = 1;
        } else if (isLastDayOfaMonth(day, month)) {
            // 这个月的最后一天，下一天就是下一个月的1号
            day = 1;
            month += 1;

        } else { // 不是月末最后一天，直接天数+1
            day += 1;
        }

        return month * 100 + day; // 计算出明天的日期
    }

    private boolean isLastDayOfaMonth(int day, int month) {
        if (month == 1 || month == 3 || month == 5 || month == 7
                || month == 8 || month == 10 || month == 12) {
            return day == 31;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return day == 30;
        } else if (month == 2) {
            return day == 28;
        } else {
            throw new RuntimeException("unknown month");
        }
    }

    private boolean isLastDayofaYear(int day, int month) {
        return month == 12 && day == 31;
    }
}
