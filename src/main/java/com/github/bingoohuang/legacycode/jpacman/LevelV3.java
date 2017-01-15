package com.github.bingoohuang.legacycode.jpacman;

import java.util.List;

/**
 * @author bingoohuang [bingoohuang@gmail.com] Created on 2017/1/15.
 */
public class LevelV3 {
    private boolean inProgress;
    private final List<LevelObserver> observers;

    LevelV3(List<LevelObserver> observers) {
        this.observers = observers;
    }

    public void start() {
        if (inProgress) {
            return;
        }
        inProgress = true;

        updateObservers();    // 提取方法
    }

    private void updateObservers() {
        updateObserversPlayerDied();
        updateObserversPelletsEaten();
    }

    private void updateObserversPlayerDied() {
        if (!isAnyPlayerAlive()) {
            for (LevelObserver o : observers) {
                o.levelLost();
            }
        }
    }

    private void updateObserversPelletsEaten() {
        if (remainingPellets() == 0) {
            for (LevelObserver o : observers) {
                o.levelWon();
            }
        }
    }

    private int remainingPellets() {
        return 0;
    }

    private boolean isAnyPlayerAlive() {
        return false;
    }
}
