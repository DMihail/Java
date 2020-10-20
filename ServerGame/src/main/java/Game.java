import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {
    private Gamer gamer = new Gamer();
    private Map<String,Plant> plants = new HashMap<String,Plant>();
    private Scanner scan = new Scanner(System.in);

    public Game() {
        plants.put("Томат", new Plant("Томат", 100, 25, 1500));
        plants.put("Арбуз", new Plant("Арбуз", 250, 50, 1000));
        plants.put("Роза", new Plant("Роза", 1000, 100, 3000));
    }

    public void printRule() {
        System.out.println("Инструкция  к игре: ");
        System.out.println(
                "1. Чтоб посадить растение выбирете пункт меню '1', " +
                "введите номер клетки в которое хотите посадить растеник и выбирете какое \n" +
                "2. Чтоб собрать растение выбирете пункт меню, '2'" +
                "введите номер клетки \n"
        );
    }

    private void PrintGameMain() {
        System.out.println(
                "1. Посадить растение \n" +
                "2. Собрать урожай \n"
        );
    }

    private void PrintPlantList() {
        System.out.println("Выбирите растение! ");
        int i = 0;
        for (String plant: plants.keySet()) {
            i++;
            System.out.println(i + ". " +plant);
        }
    }

    private void choseItemMainGame() {
        switch (scan.nextInt()) {
            case 1:
                PrintPlantList();
                choseItemMainPlant();
                break;
            case 2:
                break;
            default:
                System.out.println("Введите номер пункта из списка");
                PrintGameMain();
                break;
        }
    }

    private void choseItemMainPlant() {
//        switch (scan.nextInt()) {
//            case 1:
//                break;
//
//        }
    }


    public void Game() {
        PrintGameMain();
        choseItemMainGame();
    }

}
