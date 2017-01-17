package com.github.bingoohuang.building_maintainable_software.ch06.camera.simpledigitalcamera;

import java.awt.Image;

public class SmartphoneApp {
    private static SimpleDigitalCamera camera = SDK.getCamera();

    public static void main(String[] args) {
        // ...
        Image image = camera.takeSnapshot();
        // ...
    }
}