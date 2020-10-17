package com.company;

import java.util.*;

public class Main {
    public static String history;
    public static Grid grid = new Grid();
    public static FS fs = new FS();

    public static void main(String[] args) {
        history = fs.getHistoryGame();
        printGameMain();
    }

    public static void setGamersName(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Для начала игры введите имена игроков");
        Gamer gamer1 = new Gamer();
        Gamer gamer2 = new Gamer();
        System.out.println("Имя 1 игрока");
        gamer1.setName(scan.nextLine());
        System.out.println("Имя 2 игрока");
        gamer2.setName(scan.nextLine());
        Game(gamer1, gamer2);
    }

    public static void Game(Gamer gamer1, Gamer gamer2) {
        Scanner scan = new Scanner(System.in);
        int  gameOver = 0, number = 0, result = 0;
        grid.setNewGrid();
        System.out.println("Для того чтобы поставить Х или 0 введите номер ячейки во время хода");
        grid.printGrid();

        while (gameOver <= 0) {
            X:
            {
                System.out.println(gamer1.getName() + " введети номер клетки");
                number = scan.nextInt();
                boolean bool = grid.isPartOfGrid(number);
                if (bool) {
                    grid.setXOfTheGrid(number);
                    grid.printGrid();
                } else {
                    break X;
                }
            }
            result = grid.checkForWinnings();
            if (result != 0) {
                break;
            }
            O:{
                System.out.println(gamer2.getName() + " введети номер клетки");
                number = scan.nextInt();
                if (grid.isPartOfGrid(number)) {
                    grid.set0OfTheGrid(number);
                    grid.printGrid();
                }
            }
           result = grid.checkForWinnings();
           gameOver = result;
            }
            printResult(gamer1, gamer2, result);
            newGame();
    }

    private static void printResult(Gamer gemer1, Gamer gamer2, int result) {
        switch (result){
            case 1:
                fs.setHistory(gemer1.getName(), gamer2.getName(), gemer1.printWinner(), grid.getStringGrid());
                break;
            case 2:
                fs.setHistory(gemer1.getName(), gamer2.getName(), gamer2.printWinner(), grid.getStringGrid());
                break;
            case -1:
                System.out.println("Ничья");
                fs.setHistory(gemer1.getName(), gamer2.getName(), "Ничья", grid.getStringGrid());
                break;
            default:
                break;
        }
    }

    public static void newGame() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Новая игра?(y/n)");

        switch (scan.nextLine()) {
            case "y" :
                setGamersName();
                break;
            default:
                quittingTheGame();
                break;
        }

    }

    public static void printHistory() {
        List<String> list = new ArrayList();
        if (history.length() > 0) {
            list.addAll(Arrays.asList(history.split("\n")));

            for (int j = 0; j < list.toArray().length; j += 4) {
                System.out.println("Играли " + list.get(j) + " и " + list.get(j + 1) );
                if (list.get(j + 2).equals("Ничья")) {
                    System.out.println(list.get(j + 2));
                } else {
                    System.out.println(list.get(j + 2));
                }
                grid.printHistoryGrid(list, j);
            }
        } else {
        System.out.println("История пуста");
    }
        printGameMain();
    }

    public static void printGameMain() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Выбирите пункт меню");
        System.out.println("1 Играть");
        System.out.println("2 История");
        System.out.println("3 Выход");

        int paragraph = scan.nextInt();
        switch (paragraph) {
            case 1: setGamersName();
                break;
            case 2: printHistory();
                break;
            case 3: quittingTheGame();
                break;
            default: printGameMain();
                break;
        }
    }

    public static void quittingTheGame() {
        System.exit(0);
    }
}
