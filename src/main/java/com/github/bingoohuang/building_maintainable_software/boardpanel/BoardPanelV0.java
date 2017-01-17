package com.github.bingoohuang.building_maintainable_software.boardpanel;

import java.awt.*;
import java.util.List;

/**
 * @author bingoohuang [bingoohuang@gmail.com] Created on 2017/1/17.
 */
public class BoardPanelV0 {
    /**
     * Renders a single square on the given graphics context on the specified
     * rectangle.
     *
     * @param square The square to render.
     * @param g      The graphics context to draw on.
     * @param x      The x position to start drawing.
     * @param y      The y position to start drawing.
     * @param w      The width of this square (in pixels).
     * @param h      The height of this square (in pixels).
     */
    private void render(Square square, Graphics g, int x, int y, int w, int h) {
        square.getSprite().draw(g, x, y, w, h);
        for (Unit unit : square.getOccupants()) {
            unit.getSprite().draw(g, x, y, w, h);
        }
    }

    private class Sprite {
        @SuppressWarnings("unused")
        public void draw(Graphics g, int x, int y, int w, int h) {

        }
    }

    private class Unit {
        public Sprite getSprite() {
            return null;
        }
    }

    private class Square extends Unit {

        public List<Unit> getOccupants() {
            return null;
        }

    }
}
