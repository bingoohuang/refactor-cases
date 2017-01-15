package com.github.bingoohuang.legacycode.jpacman;

/**
 * @author bingoohuang [bingoohuang@gmail.com] Created on 2017/1/15.
 */
public class Level {
    private boolean inProgress;

    // JPacMan框架，为了讲授如何进行测试，

    // JPacMan: https://github.com/SERG-Delft/jpacman-framework
    // start 方法的最初版本会检查游戏是否已经开始。如果已经开始，它会直接返回。
    // 否则它会更新私有成员变量inProgress，来维护其自身状态
    public void start() {
        if (inProgress) {
            return;
        }
        inProgress = true;
    }

    // 添加新功能，高速本关卡所有观察者当前的游戏状态。
    // 如果玩家死亡我们就高速所有观察者本关结束。
    // 如果所有的豆都被吃光我们就高速我有观察者游戏胜利。
}
