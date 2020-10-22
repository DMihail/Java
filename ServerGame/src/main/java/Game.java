import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {
    private Gamer gamer = new Gamer();
    private Map<String,Plant> plants = new HashMap<String,Plant>();
    private Scanner scan = new Scanner(System.in);
    private  Grid grid = new Grid();

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
                "2. Собрать урожай \n"+
                "3. Показать карту \n"+
                "4. Показать баланс \n"+
                "5. Показать правила \n"+
                "6. Выйти \n"
        );
    }

    public void PrintPlantList() {
        System.out.println("Выбирите растение! ");
        int i = 0;
        for (String plant: plants.keySet()) {
            i++;
            System.out.println(i + ". " +plant);
        }
    }

    private void choseItemMainGame() {
        System.out.println("Введите номер пункта из списка");
        switch (scan.nextInt()) {
            case 1:
                PrintPlantList();
                choseItemMainPlant();
                break;
            case 2:
                break;
            case 3:
                grid.printGrid();
                break;
            case 4:
                break;
            case 5:
                printRule();
                break;
            case 6:
                Exit();
                break;
            default:
                System.out.println("Неверное значение");
                PrintGameMain();
                break;
        }

    }

    private void aging(String name) {
        Plant plant = plants.get(name);
        System.out.println("Введите номер ячейки для  посадки растения ");
        int index = scan.nextInt();
        boolean is = grid.isPartGridEmpty(index);
        if (is) {
            if (!plant.plantHerb(index)) {
                PrintGameMain();
//                grid.printGrid();
            }
        }
        else {
            System.out.println("Данная ячейка занята введите номер пустой ячейки ");
            aging(name);
        }
    }


    private void choseItemMainPlant() {
        switch (scan.nextInt()) {
            case 1:
                aging("Томат");
                break;
            default:
                PrintGameMain();
                choseItemMainGame();
                break;
        }
    }


    public void Game() {
        PrintGameMain();
        choseItemMainGame();
    }

    private void Exit() {
        grid.printGrid();
    }

}
