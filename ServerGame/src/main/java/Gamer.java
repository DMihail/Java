public class Gamer {

    private int money = 1000;

    protected boolean buySeeds(float sum) {
        if (money >= sum) {
            money -= sum;
            return true;
        }
        return false;
    }

    protected void printMoney() {
        System.out.println("Текущий баланс = " + money);
    }

    protected void addMoney(float sum) {
        money += sum;
    }
}
