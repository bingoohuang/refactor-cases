package com.github.bingoohuang.legacycode.jpacman;

import java.util.List;

/**
 * @author bingoohuang [bingoohuang@gmail.com] Created on 2017/1/15.
 */
public class LevelV2 {
    private boolean inProgress;
    private final List<LevelObserver> observers;

    LevelV2(List<LevelObserver> observers) {
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
        // Update observers if player died:
        if (!isAnyPlayerAlive()) {
            for (LevelObserver o : observers) {
                o.levelLost();
            }
        }
        // Update observers if all pellets eaten:
        if (remainingPellets() == 0) {
            for (LevelObserver o : observers) {
                o.levelWon();
            }
        }
    }
    // 该方法仍然有两个职责

    private int remainingPellets() {
        return 0;
    }

    private boolean isAnyPlayerAlive() {
        return false;
    }
}
