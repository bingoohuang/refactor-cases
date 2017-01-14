package com.github.bingoohuang.legacycode.nextday;

/**
 * @author bingoohuang [bingoohuang@gmail.com] Created on 2017/1/14.
 */
public class NextDay {
    // 给定一个日期，即年 月 日，让你给出下一天的表述。
    // 即2000-1-1 ==》 2000-1-2， 2000-1-31==》2000-2-1  2000-12-31==》2001-1-1
    // 这里简化了一些，给各位一些看代码的耐心。只给出月 日， 然后二月固定为28天。
    int nextdate(int month, int day) {
        if (day >= 28) /* 如果是一个月的最后一天*/ {
            if (month == 1 || month == 3 || month == 5 || month == 7
                    || month == 8 || month == 10 || month == 12) {
                if (day >= 31) {  // 这个月的最后一天， 需要同时调整 月 日
                    day = 1;
                    month += 1;
                    if (month > 12) /* 一年的最后一天，需要同时调整年 月 日*/ {
                        month = 1;
                    }
                } else {
                    day += 1;
                }

            } else if (month == 2) {
                // 非闰年28号是2月的最后一天
                day = 1;
                month += 1;
            } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                if (day >= 30) /* 是30号*/ {
                    day = 1;
                    month += 1;
                } else {
                    day += 1;
                }
            }
        } else {
            // 如果不是一个月的最后一天,则day直接加1
            day += 1;
        }

        return month * 100 + day; // 计算出明天的日期
    }
    // 每次看这样的代码，不得不说要减寿半年。
    // 所以在正式化简之前，为了不致各位看官的手臂男，我先大概聊一聊这个程序：
    // 基本的算法逻辑：计算下一天时，如果是这一年的最后一天，
    // 那么就是下一年的1月1日；如果是某个月的最后一天，那么下一天就是下一个月的第一天 ；
    // 否则只要简单的天数+1就可以了。
    // 第一个if (day >=28) 作者用意是这样的：如果小于28，
    // 不论 是哪个月，都不会是该月最后一天。所以只要天数直接+1就可以了。
    // 如果day >=28, 那么对不同的月份，就可能是月末最后一天，也可能不是，具体再用if else处理。

}
