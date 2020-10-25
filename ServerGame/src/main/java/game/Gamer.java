package game;

public class Gamer {

    private int money = 100;

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
}
