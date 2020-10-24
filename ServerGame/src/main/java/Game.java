
import com.fasterxml.jackson.databind.JsonNode;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {
    private Gamer gamer = new Gamer();
    private Map<String, JsonNode> plants = new HashMap<>();
    private Scanner scan = new Scanner(System.in);
    private  Map<Integer,Plant> gridMap = new HashMap<Integer,Plant>();
    private  Grid grid = new Grid();
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
        System.out.println("Выбирите растение!");
        int i = 0;
        for (String name: plants.keySet()){
            i++;
            System.out.println(i + ". " + name);
        }
    }

    private void choseItemMainGame() {
        System.out.println("Введите номер пункта из списка");
        switch (scan.nextInt()) {
            case 1:
                PrintPlantList();
                choseItemMainPlant();
                aging();
                break;
            case 2:
                harvest();
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
                PrintGameMain();
                break;
        }

    }

    private void harvest() {
        System.out.println("Введите номер клетки в которой хотите собрать урожай");
        int index = scan.nextInt();
        Plant plant = gridMap.get(index);
        plant.harvest(gamer);
        grid.setPlantOfTheGrid(index, " ");
    }

    private void aging() {
        Plant plant = new Plant();
        JsonNode parametrs = plants.get(plantName);
        System.out.println(parametrs);
        plant.getPlantParameters(plantName, parametrs.get("harvestCost").asInt(), parametrs.get("seedCost").asInt(), parametrs.get("speedMaturation").asInt(), gamer);
        System.out.println("Введите номер ячейки для  посадки растения ");
        int index = scan.nextInt();
        boolean is = grid.isPartGridEmpty(index);
        if (is) {
            if (!plant.plantHerb(index, grid)) {
                PrintGameMain();
            }
            gridMap.put(index, plant);
        }
        else {
            System.out.println("Данная ячейка занята введите номер пустой ячейки ");
            aging();
        }
    }


    private void choseItemMainPlant() {
        int index = scan.nextInt();
        String[] strings = plants.keySet().toArray(new String[plants.size()]);
        plantName = strings[index - 1];
    }


    public void Game() {
        for (;;) {
            PrintGameMain();
            choseItemMainGame();
        }
    }

    private void Exit() {
        System.exit(0);
    }

}
