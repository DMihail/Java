package game;

public class Seed {
    protected String name;
    protected int harvestCost;
    protected int seedCost;
    protected int speedMaturation;

    public void getSeedParameters(String name, int harvestCost, int seedCost, int speedMaturation) {
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