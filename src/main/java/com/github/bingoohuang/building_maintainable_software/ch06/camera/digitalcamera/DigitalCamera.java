package com.github.bingoohuang.building_maintainable_software.ch06.camera.digitalcamera;

import java.awt.*;
import java.awt.image.BufferedImage;

public class DigitalCamera {
    public Image takeSnapshot() {
        // ...
        return new BufferedImage(1920, 1080, BufferedImage.TYPE_INT_ARGB);
    }

    public void flashLightOn() {
        // ... 
    }

    public void flaslLightOff() {
        // ... 
    }
}