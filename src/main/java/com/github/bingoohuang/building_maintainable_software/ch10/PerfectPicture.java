package com.github.bingoohuang.building_maintainable_software.ch10;

import com.github.bingoohuang.building_maintainable_software.ch06.camera.simpledigitalcamera.SimpleDigitalCamera;

import java.awt.*;


public class PerfectPicture {
    public static SimpleDigitalCamera camera = null;

    public final static int DAYLIGHT_START = 6;

    public Image takePerfectPicture(int currentHour) {
        Image image;
        if (currentHour < PerfectPicture.DAYLIGHT_START) {
            camera.flashLightOn();
            image = camera.takeSnapshot();
            camera.flashLightOff();
        } else {
            image = camera.takeSnapshot();
        }
        return image;
    }
}
