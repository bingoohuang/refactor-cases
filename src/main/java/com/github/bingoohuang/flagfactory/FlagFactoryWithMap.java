package com.github.bingoohuang.flagfactory;

import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.awt.Color.*;

/**
 * @author bingoohuang [bingoohuang@gmail.com] Created on 2017/1/14.
 */
public class FlagFactoryWithMap {
    final static Map<Nationality, List<Color>> FLAGS = new HashMap<>();

    static {
        FLAGS.put(Nationality.DUTCH, Arrays.asList(RED, WHITE, BLUE));
        FLAGS.put(Nationality.GERMAN, Arrays.asList(BLACK, RED, YELLOW));
        FLAGS.put(Nationality.BELGIAN, Arrays.asList(BLACK, YELLOW, RED));
        FLAGS.put(Nationality.FRENCH, Arrays.asList(BLUE, WHITE, RED));
        FLAGS.put(Nationality.ITALIAN, Arrays.asList(GREEN, WHITE, RED));
    }

    public List<Color> getFlagColors(Nationality nationality) {
        return FLAGS.getOrDefault(nationality, Arrays.asList(Color.GRAY));
    }
}
