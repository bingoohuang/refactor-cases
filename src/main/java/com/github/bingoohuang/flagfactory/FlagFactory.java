package com.github.bingoohuang.flagfactory;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

/**
 * from https://github.com/oreillymedia/building_maintainable_software/blob/master/src/java/eu/sig/training/ch03/FlagFactory.java
 * 《代码不朽-编写可维护代码的10大原则》-第3章，编写简单的代码单元，限制代码单元分支不超过4个。
 * @author bingoohuang [bingoohuang@gmail.com] Created on 2017/1/12.
 */
public class FlagFactory {
    public List<Color> getFlagColors(Nationality nationality) {
        List<Color> result;
        switch (nationality) {
            case DUTCH:
                result = Arrays.asList(Color.RED, Color.WHITE, Color.BLUE);
                break;
            case GERMAN:
                result = Arrays.asList(Color.BLACK, Color.RED, Color.YELLOW);
                break;
            case BELGIAN:
                result = Arrays.asList(Color.BLACK, Color.YELLOW, Color.RED);
                break;
            case FRENCH:
                result = Arrays.asList(Color.BLUE, Color.WHITE, Color.RED);
                break;
            case ITALIAN:
                result = Arrays.asList(Color.GREEN, Color.WHITE, Color.RED);
                break;
            case UNCLASSIFIED:
            default:
                result = Arrays.asList(Color.GRAY);
                break;
        }
        return result;
    }

    // 这个方法超过15行，有超过4个的条件分支（实际6个）
}

