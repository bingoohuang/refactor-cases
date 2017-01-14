package com.github.bingoohuang.legacycode.scores;

/**
 * @author bingoohuang [bingoohuang@gmail.com] Created on 2017/1/14.
 */
public class Scores {
    /**
     * 按成绩排等级:90分以上A， 80-90 B， 70-80 C， 60-70 D， 60以下 E
     *
     * @param score
     * @return string of degree, such as A, B, C, D, E
     */
    String degree(int score) {
        if (score < 80) {
            if (score < 70) {
                if (score < 60) {
                    return "E";
                } else {
                    return "D";
                }
            } else {
                return "C";
            }
        } else {
            if (score < 90) {
                return "B";
            } else {
                return "A";
            }
        }
    }
}
