package com.github.bingoohuang.building_maintainable_software.ch06.camera.advanceddigitalcamera;

import java.awt.Image;
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

    public Image takePanoramaSnapshot() {
        return new BufferedImage(1920, 1080, BufferedImage.TYPE_INT_ARGB);
        // ...
    }

    public Video record() {
        // ...
        return new Video();
    }

    public void setTimer(int seconds) {
        // ... 
    }

    public void zoomIn() {
        // ...
    }

    public void zoomOut() {
        // ... 
    }
}