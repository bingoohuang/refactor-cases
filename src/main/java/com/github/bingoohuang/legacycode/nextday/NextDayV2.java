package com.github.bingoohuang.legacycode.nextday;

/**
 * @author bingoohuang [bingoohuang@gmail.com] Created on 2017/1/14.
 */
public class NextDayV2 {
    int nextdate(int year, int month, int day) {
        if (day < 28) { // 如果不是一个月的最后一天,则day直接加1
            day += 1;
            return month * 100 + day; // 计算出明天的日期
        }

        if ((month == 1 || month == 3 || month == 5 || month == 7
                || month == 8 || month == 10 || month == 12) && (day >= 31)) {
            // 这个月的最后一天， 需要同时调整 月 日
            day = 1;
            month += 1;
            if (month > 12) /* 一年的最后一天，需要同时调整年 月 日*/ {
                year += 1;
                month = 1;
            }

        } else if ((month == 1 || month == 3 || month == 5 || month == 7
                || month == 8 || month == 10 || month == 12) && !(day >= 31)) {
            day += 1;
        } else if (month == 2) {
            // 非闰年28号是2月的最后一天
            day = 1;
            month += 1;
        } else if ((month == 4 || month == 6 || month == 9 || month == 11) && (day >= 30)) {
            // 30号是這些月份的最后一天
            day = 1;
            month += 1;
        } else if ((month == 4 || month == 6 || month == 9 || month == 11) && !(day >= 30)) {
            day += 1;
        }

        return month * 100 + day; // 计算出明天的日期
    }
}
