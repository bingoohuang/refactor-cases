package com.github.bingoohuang.legacycode.jpacman;

import java.util.List;

/**
 * @author bingoohuang [bingoohuang@gmail.com] Created on 2017/1/15.
 */
public class LevelV1 {
    private boolean inProgress;
    private final List<LevelObserver> observers;

    LevelV1(List<LevelObserver> observers) {
        this.observers = observers;
    }

    public void start() {
        if (inProgress) {
            return;
        }
        inProgress = true;

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

    private int remainingPellets() {
        return 0;
    }

    private boolean isAnyPlayerAlive() {
        return false;
    }
}

