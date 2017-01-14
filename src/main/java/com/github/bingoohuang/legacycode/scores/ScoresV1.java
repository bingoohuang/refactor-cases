package com.github.bingoohuang.legacycode.scores;

/**
 * @author bingoohuang [bingoohuang@gmail.com] Created on 2017/1/14.
 */
public class ScoresV1 {
    // 直接摘录《C++编程规范》一书中的一节内容：
    // 不要进行不成熟的优化。 优化的第一原则：不要优化。 第二原则（仅适用于专家，不是砖家哦）：还是不要优化。再三测试，而后优化。
    // 正确、简单和清晰第一。简单就是美：正确优于速度；简单优于复杂；清晰由于技巧；安全优于不安全
    String degree(int score) {
        if (score < 60) return "E";
        if (score < 70) return "D";
        if (score < 80) return "C";
        if (score < 90) return "B";
        return "A";
    }
}
