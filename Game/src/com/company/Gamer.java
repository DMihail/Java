package com.company;

public class Gamer {
    private String name;

    public String getName(){
        return name;
    }

    public void setName(String a){
        name=a;
    }

    public String printWinner() {
        String winner = "Победитель " + name;
        System.out.println(winner);
        return winner;
    }
}
