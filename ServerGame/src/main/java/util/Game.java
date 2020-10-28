package util;
import game.*;
import jackson.JsonParser;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {
    private Gamer gamer = new Gamer();
    private Map<String, Seed> plants = new HashMap<>();
    private Scanner scan = new Scanner(System.in);
    private  Map<Integer, Plant> gridMap = new HashMap<Integer, Plant>();
    private Grid grid = new Grid();
    private String plantName;

    public Game() {
        JsonParser json = new JsonParser();
        plants = json.getMapPlantsObj();
    }

    public void printRule() {
        System.out.println("Инструкция  к игре: ");
        System.out.println(
                "1. Чтоб посадить растение выбирете пункт меню '1', " +
                "введите номер клетки в которое хотите посадить растеник и выбирете какое \n" +
                "2. Чтоб собрать растение выбирете пункт меню, '2'" +
                "введите номер клетки, деньги за урожай сразу будут зачислены на ваш баланс \n" +
                 "3. Буква в ячейке таблицы значит статус посаженого растения, З - зреет, У - можно собирать урожай\n"
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
        System.out.println("Выбирите растение!");
        int i = 0;
        for (String name: plants.keySet()){
            i++;
            System.out.println(i + ". " + name);
        }
    }

    public void setScanIndex(int main) {
        if (main < 3) {
            System.out.println("Введите номер пункта из списка");
        } else if (main == 3){
            System.out.println("Введите номер клетки в которой хотите собрать урожай");
        } else if(main == 4) {
            System.out.println("Введите номер ячейки для  посадки растения ");
        }
             while (!scan.hasNextInt()) {
                 System.out.println("Введите номер пункта");
                scan.nextLine();
                }
                int index = scan.nextInt();
             if (index <= 8) {
                 if (main == 1) {
                     choseItemMainGame(index);
                 } else if (main == 2) {
                     choseItemMainPlant(index);
                 } else if (main == 3) {
                     harvest(index);
                 } else if (main == 4) {
                     aging(index);
                 }
             } else {
                 setScanIndex(main);
             }
    }
    private interface choseItemMainGame{
            void choseItemMainGame(int index);
    }

    private void choseItemMainGame(int index) {
        switch (index) {
            case 1:
                PrintPlantList();
                setScanIndex(2);
                if (checkSum()) {
                    setScanIndex(4);
                }
                break;
            case 2:
                setScanIndex(3);
                break;
            case 3:
                grid.printGrid();
                break;
            case 4:
                gamer.printMoney();
                break;
            case 5:
                printRule();
                break;
            case 6:
                Exit();
                break;
            default:
                System.out.println("Неверное значение");
                Game();
                break;
        }
    }

    private void harvest(int index) {
        if (grid.isPlantRipe(index)) {
            Plant plant = gridMap.get(index);
            gamer.harvest(grid, index, plant.getHarvestCost());

        }
    }

    private void aging(int index) {
        Plant plant = new Plant();
        Seed parametrs = plants.get(plantName);
        plant.getPlantParameters(plantName,
                parametrs.getHarvestCost(),
                parametrs.getSeedCost(),
                parametrs.getSpeedMaturation());

        boolean is = grid.isPartGridEmpty(index);
        if (is) {
                gamer.plantHerb(parametrs.getSpeedMaturation(), index, grid);
                gridMap.put(index, plant);
        }
        else {
            System.out.println("Данная ячейка занята введите номер пустой ячейки ");
            setScanIndex(4);
        }
    }


    private void choseItemMainPlant(int index) {
        String[] strings = plants.keySet().toArray(new String[plants.size()]);
        plantName = strings[index - 1];
    }


    public void Game() {
        for (;;) {
            PrintGameMain();
            setScanIndex(1);
        }
    }

    boolean checkSum() {
        Seed parametrs = plants.get(plantName);
        int cost = parametrs.getSeedCost();
        boolean answer = gamer.buySeeds(cost);
        if(!answer) {
            System.out.println("Недостаточно Денег на покупку " + plantName);
            return false;
        }
        return true;
    }

    private void Exit() {
        System.exit(0);
    }
}

enum Functions {
    MAIN_GAME,
    MAIN_PLANT,
    HARVEST,
    AGING
}