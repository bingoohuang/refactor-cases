package com.github.bingoohuang.building_maintainable_software.ch06.camera.digitalcamera;

import java.awt.Image;

public class SmartphoneApp {
    private static DigitalCamera camera = new DigitalCamera();

    public static void main(String[] args) {
        // ...        
        Image image = camera.takeSnapshot();
        // ...
    }
}