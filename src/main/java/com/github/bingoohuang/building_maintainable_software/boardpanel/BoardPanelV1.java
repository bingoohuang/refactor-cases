package com.github.bingoohuang.building_maintainable_software.boardpanel;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.awt.*;
import java.util.List;

/**
 * @author bingoohuang [bingoohuang@gmail.com] Created on 2017/1/17.
 */
public class BoardPanelV1 {
    /**
     * Renders a single square on the given graphics context on the specified
     * rectangle.
     *
     * @param square The square to render.
     * @param g      The graphics context to draw on.
     * @param r      The position and dimension for rendering the square.
     */
    private void render(Square square, Graphics g, Rectangle r) {
        Point position = r.getPosition();
        square.getSprite().draw(g, position.x, position.y, r.getWidth(), r.getHeight());
        for (Unit unit : square.getOccupants()) {
            unit.getSprite().draw(g, position.x, position.y, r.getWidth(), r.getHeight());
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

    @Getter @AllArgsConstructor
    public static class Rectangle {
        private final Point position;
        private final int width;
        private final int height;
    }
}
