package com.company;

public class Gamer {

    private int money;

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
