package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Grid {

private int [] grid = {0, 0, 0,
                       0, 0, 0,
                       0, 0, 0};
    private int[][] winningOptions = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7 ,8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {0, 4, 8},
            {2, 4 ,6},
    };

    public String getStringGrid() {
        String stringGrid = "";
        for (int n: grid) {
            stringGrid += n;
        }
        return stringGrid;
    }

    public void setXOfTheGrid(int numPart) {
        grid[numPart] = 1;
    }
    public void set0OfTheGrid(int numPart) {
        grid[numPart] = 4;
    }

    public boolean isPartOfGrid(int numPart) {
        if (grid[numPart] > 0) {
            System.out.println("Данная ячейка заната, введите другой номер!");
            return false;
        }
        return true;
    }

    public void printGrid() {
        printPartGrid(-3, 0);
        for (int i = 0; i < grid.length; i++) {
            if (i!=0){
                    if (i % 3 == 0) {
                        printPartGrid(-1, 0);
                    } else
                        printPartGrid(-4, 0);
            }
            printPartGrid(grid[i], i);
        }
        printPartGrid(-2, 0);
    }

    public void setNewGrid() {
        grid = new int[]{0, 0, 0,
                        0, 0, 0,
                        0, 0, 0};
    }

    public int checkForWinnings(){
        for (int i = 0; i < winningOptions.length; i++) {
            int sum = 0;
            for (int j = 0; j < winningOptions[i].length; j++) {
                int index= winningOptions[i][j];
                sum += grid[index];
            }
            if (sum == 3) {
                return 1;
            } else if (sum == 12) {
                return 2;
            }
        }
        boolean isO = IntStream.of(grid).anyMatch(x -> x == 0);
        System.out.println(isO);
        if (!isO) {
            return -1;
        }
        return  0;
    }

    public void printHistoryGrid(List <String> list, int j) {
                System.out.println("Вид поля игры: ");
                printPartGrid(-3, 0);
                for (int i = 0; i < grid.length; i++) {
                    if (i != 0) {
                        if (i % 3 == 0) {
                            printPartGrid(-1, 0);
                        } else
                            printPartGrid(-4, 0);
                    }
                    int num = Integer.parseInt(list.get(j + 3).substring(i, i + 1));
                    printPartGrid(num, i);
                }
                printPartGrid(-2, 0);
    }

        private void printPartGrid(int part, int i ) {
            if (part == -1) {
                System.out.println();
                System.out.println("_____|_____|_____");
                System.out.println("     |     |     ");
            } else if (part == -2) {
                System.out.println();
                System.out.println("     |     |     ");
            }
            else if (part == -3) {
                System.out.println("     |     |     ");
            }
            else if (part == -4) {
                System.out.print("|");
            }else {
                if (part == 0) System.out.print("  " + i + "  ");
                if (part == 1) System.out.print("  X  ");
                if (part == 4) System.out.print("  O  ");
            }
    }
}
