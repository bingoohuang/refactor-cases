package com.github.bingoohuang.building_maintainable_software.boardfactory;

/**
 * @author bingoohuang [bingoohuang@gmail.com] Created on 2017/1/15.
 */
public class BoardFactoryV3 {
    public Board createBoard(Square[][] grid) {
        return new BoardCreator(grid).create();
    }
}
