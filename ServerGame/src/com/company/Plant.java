package com.company;

public class Plant {

    private String name;
    private int harvestCost;
    private int seedCost;
    private int speedMaturation;

    public void setPlantData(String name, int harvestCost, int seedCost, int speedMaturation) {
        this.name = name;
        this.harvestCost = harvestCost;
        this.seedCost = seedCost;
        this.speedMaturation = speedMaturation;
    }

}
