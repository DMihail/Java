package game;

public class PlantParams{
    private String name;
    private int harvestCost;
    private int seedCost;
    private int speedMaturation;

    public void getPlantParameters(String name, int harvestCost, int seedCost, int speedMaturation) {
        this.name = name;
        this.harvestCost = harvestCost;
        this.seedCost = seedCost;
        this.speedMaturation = speedMaturation;
    }

    public String getName() {
        return name;
    }

    public int getHarvestCost() {
        return harvestCost;
    }

    public int getSeedCost() {
        return seedCost;
    }

    public int getSpeedMaturation() {
        return speedMaturation;
    }
}