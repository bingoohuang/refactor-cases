package com.github.bingoohuang.building_maintainable_software.ch07;

public class AWSCloudServerFactory implements CloudServerFactory {
    public CloudServer launchComputeServer() {
        return new AWSComputeServer();
    }

    public CloudServer launchDatabaseServer() {
        return new AWSDatabaseServer();
    }

    public CloudStorage createCloudStorage(long sizeGb) {
        return new AWSCloudStorage(sizeGb);
    }
}