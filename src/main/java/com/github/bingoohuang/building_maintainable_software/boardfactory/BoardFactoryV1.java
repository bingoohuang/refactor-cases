package com.github.bingoohuang.building_maintainable_software.boardfactory;

/**
 * @author bingoohuang [bingoohuang@gmail.com] Created on 2017/1/15.
 */
public class BoardFactoryV1 {
    public Board createBoard(Square[][] grid) {
        assert grid != null;

        Board board = new Board(grid);

        int width = board.getWidth();
        int height = board.getHeight();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Square square = grid[x][y];
                for (Direction dir : Direction.values()) {
                    setLink(square, dir, x, y, width, height, grid);
                }
            }
        }

        return board;
    }

    // 但是传递了超过了4个参数（实际7个参数）
    private void setLink(Square square, Direction dir, int x, int y, int width,
                         int height, Square[][] grid) {
        int dirX = (width + x + dir.getDeltaX()) % width;
        int dirY = (height + y + dir.getDeltaY()) % height;
        Square neighbour = grid[dirX][dirY];
        square.link(neighbour, dir);
    }

    // 我们换一种方式，尝试使用『将方法替换为方法对象』的技巧，创建一个新的类来代替createBoard方法
}
