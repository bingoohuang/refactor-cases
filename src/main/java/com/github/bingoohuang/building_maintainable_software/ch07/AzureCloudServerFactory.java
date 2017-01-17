package com.github.bingoohuang.building_maintainable_software.ch07;

public class AzureCloudServerFactory implements CloudServerFactory {
    public CloudServer launchComputeServer() {
        return new AzureComputeServer();
    }

    public CloudServer launchDatabaseServer() {
        return new AzureDatabaseServer();
    }

    public CloudStorage createCloudStorage(long sizeGb) {
        return new AzureCloudStorage(sizeGb);
    }
}