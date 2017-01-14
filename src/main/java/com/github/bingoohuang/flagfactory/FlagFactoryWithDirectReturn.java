package com.github.bingoohuang.flagfactory;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

/**
 * @author bingoohuang [bingoohuang@gmail.com] Created on 2017/1/14.
 */
public class FlagFactoryWithDirectReturn {
    public List<Color> getFlagColors(Nationality nationality) {
        switch (nationality) {
            case DUTCH:
                return Arrays.asList(Color.RED, Color.WHITE, Color.BLUE);
            case GERMAN:
                return Arrays.asList(Color.BLACK, Color.RED, Color.YELLOW);
            case BELGIAN:
                return Arrays.asList(Color.BLACK, Color.YELLOW, Color.RED);
            case FRENCH:
                return Arrays.asList(Color.BLUE, Color.WHITE, Color.RED);
            case ITALIAN:
                return Arrays.asList(Color.GREEN, Color.WHITE, Color.RED);
            case UNCLASSIFIED:
            default:
                return Arrays.asList(Color.GRAY);
        }
    }

    // 重构完成之后，只有15行代码了，刚好符合每个方法不超过15行代码的要求。
}
