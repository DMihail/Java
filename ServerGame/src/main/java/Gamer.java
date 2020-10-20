public class Gamer {

    private int money = 1000;

    public boolean buySeeds(float sum) {
        if (money >= sum) {
            money -= sum;
            return true;
        }
        return false;
    }

    public void addMoney(float sum) {
        money += sum;
    }
}
