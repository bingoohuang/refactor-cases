package com.github.bingoohuang.building_maintainable_software.ch06.camera.simpledigitalcamera;

import java.awt.*;

public interface SimpleDigitalCamera {
    Image takeSnapshot();

    void flashLightOn();

    void flashLightOff();
}
