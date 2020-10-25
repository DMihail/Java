package game;

import  util.*;

public class Plant  {

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

    public void harvest(Gamer gamer) {
        gamer.addMoney(harvestCost);
    }

    public boolean plantHerb(int gridIndex, Grid grid) {
        boolean answer = gamer.buySeeds(seedCost);
        if(!answer) {
            System.out.println("Недостаточно Денег на покупку " + name);
            return false;
        } else {
                aging.setTimeAndIndex(speedMaturation, gridIndex, grid);
                aging.start();
        }
        return true;
    }

}
