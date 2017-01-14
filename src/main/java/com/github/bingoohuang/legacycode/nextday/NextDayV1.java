package com.github.bingoohuang.legacycode.nextday;

/**
 * @author bingoohuang [bingoohuang@gmail.com] Created on 2017/1/14.
 */
public class NextDayV1 {
    // if (day >= 28)这个语句实在是太头重脚轻了，
    // 所以使用return快速返回的手法。顺便去掉一层嵌套
    int nextdate(int month, int day) {
        if (day < 28) {// 如果不是一个月的最后一天,则day直接加1
            day += 1;
            return month * 100 + day; // 计算出明天的日期
        }

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

        return month * 100 + day; // 计算出明天的日期
    }

    // 然后观察剩下的一大串if else语句，有很多重复的代码片段，这个现象说明可能比较适合应用合并分支的手法。

    // 重复代码段day =1; month +=1;  // 表示如果是月末最后一天时，next date 就是下一个月的1号
    // 重复代码段 day += 1; // 表示如果不是月末最后一天时，next date就是 本月天数 + 1

    // 所以我们合并分支条件，将所有判定是月末最后一天的条件合并在一起。
    // 整个程序的逻辑就简化为是不是月末最后一天，如果是 do somethin 如果不是 do something。
    // 当然，到这里的时候，已经完全可以重新写一套代码，相对来说速度上比改这个代码肯定还要快一些，
    // 现实工作中 这种情形也不少遇到。不过这里为了扣住这个blog主题——“修改代码的艺术”，所以下面还是以代码重构的方式进行
    // 要合并分支，首先需要将这些分支集中到同一层。 千万不要直接上下层合并，只要稍微复杂一些，
    // 就连怎么死的都不知道。因此先做一次扁平化操作。具体怎么做，之前已经详细讲述了，这里就直接快进
}
