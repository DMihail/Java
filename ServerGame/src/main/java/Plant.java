public class Plant extends Gamer  {
    private String name;
    private int harvestCost;
    private int seedCost;
    private int speedMaturation;
    private int gridIndex;
    private Aging aging = new Aging();

    public void getPlantParameters(String name, int harvestCost, int seedCost, int speedMaturation) {
        this.name = name;
        this.harvestCost = harvestCost;
        this.seedCost = seedCost;
        this.speedMaturation = speedMaturation;
    }

    public void harvest() {


    }


    public boolean plantHerb(int gridIndex) {
        this.gridIndex = gridIndex;
        boolean answer = buySeeds(seedCost);
        if(!answer) {
            System.out.println("Недостаточно Денег на покупку " + name);
            return false;
        } else {
                aging.setTimeAndIndex(speedMaturation, gridIndex);
                aging.start();
        }
        return true;
    }

}
