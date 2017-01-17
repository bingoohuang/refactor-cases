package com.github.bingoohuang.building_maintainable_software.chartlib;

import com.github.bingoohuang.building_maintainable_software.boardpanel.BoardPanelV1.Rectangle;

import java.awt.*;

/**
 * @author bingoohuang [bingoohuang@gmail.com] Created on 2017/1/17.
 */
public class Charts {
    public static void drawBarChart(Graphics g,
                                    CategoryItemRendererState state,
                                    Rectangle graphArea,
                                    CategoryPlot plot,
                                    CategoryAxis domainAxis,
                                    ValueAxis rangeAxis,
                                    CategoryDataset dataset) {
        // ..
    }

    public static void drawBarChart(Graphics g, CategoryDataset dataset) {
        Charts.drawBarChart(g,
                CategoryItemRendererState.DEFAULT,
                new Rectangle(new Point(0, 0), 100, 100),
                CategoryPlot.DEFAULT,
                CategoryAxis.DEFAULT,
                ValueAxis.DEFAULT,
                dataset);
    }


    static class CategoryItemRendererState {
        public static final CategoryItemRendererState DEFAULT = null;
    }

    static class CategoryPlot {
        public static final CategoryPlot DEFAULT = null;
    }

    static class CategoryAxis {
        public static final CategoryAxis DEFAULT = null;
    }

    static class ValueAxis {
        public static final ValueAxis DEFAULT = null;
    }

    static class CategoryDataset {
        public static final CategoryDataset DEFAULT = null;
    }
}
