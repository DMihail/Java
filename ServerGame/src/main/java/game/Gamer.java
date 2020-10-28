package game;

import util.Aging;

public class Gamer {

    private int money = 100;
    private Aging aging = new Aging();

    public boolean buySeeds(float sum) {
        if (money >= sum) {
            money -= sum;
            return true;
        }
        return false;
    }

    public void printMoney() {
        System.out.println("Текущий баланс = " + money);
    }

    public void addMoney(float sum) {
        money += sum;
    }

    public void plantHerb(int speedMaturation, int gridIndex, Grid grid) {
        aging.setTimeAndIndex(speedMaturation, gridIndex, grid);
        aging.start();
    }

    public void harvest( Grid grid, int index, int harvestCost) {
        addMoney(harvestCost);
        printMoney();
        grid.setPlantOfTheGrid(index, " ");
    }
}
