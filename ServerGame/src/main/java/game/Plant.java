package game;
import  util.*;

public class Plant extends PlantParams {

    private String name;
    private Gamer gamer;
    private int harvestCost;
    private int seedCost;
    private int speedMaturation;
    private Aging aging = new Aging();

    public void getPlantParameters(String name, int harvestCost, int seedCost, int speedMaturation, Gamer gamer) {
        this.name = name;
        this.harvestCost = harvestCost;
        this.seedCost = seedCost;
        this.speedMaturation = speedMaturation;
        this.gamer = gamer;
    }

    public void harvest(Gamer gamer, Grid grid, int index) {
        gamer.addMoney(harvestCost);
        gamer.printMoney();
        grid.setPlantOfTheGrid(index, " ");
    }

    public void plantHerb(int gridIndex, Grid grid) {
      aging.setTimeAndIndex(speedMaturation, gridIndex, grid);
       aging.start();
    }

}
