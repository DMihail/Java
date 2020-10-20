import java.util.*;

public class Plant {

    private String name;
    private int harvestCost;
    private int seedCost;
    private int speedMaturation;
    private String status;

    public Plant(String name, int harvestCost, int seedCost, int speedMaturation) {
        this.name = name;
        this.harvestCost = harvestCost;
        this.seedCost = seedCost;
        this.speedMaturation = speedMaturation;
    }

}
