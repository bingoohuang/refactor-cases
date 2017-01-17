package com.github.bingoohuang.building_maintainable_software.ch07;

public interface CloudServerFactory {
    CloudServer launchComputeServer();

    CloudServer launchDatabaseServer();

    CloudStorage createCloudStorage(long sizeGb);
}