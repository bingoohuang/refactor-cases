package com.github.bingoohuang.building_maintainable_software.ch07;

public class ApplicationLauncher {

    public static void main(String[] args) {
        CloudServerFactory factory;
        if (args[1].equals("-azure")) {
            factory = new AzureCloudServerFactory();
        } else {
            factory = new AWSCloudServerFactory();
        }
        CloudServer computeServer = factory.launchComputeServer();
        CloudServer databaseServer = factory.launchDatabaseServer();
    }

}
