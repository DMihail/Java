package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Grid {

private int [] grid = {0, 0,
                       0, 0,
                       0, 0,
                       0, 0 };


    public void setPlantOfTheGrid(int numPart, int plantIndex) {
        grid[numPart] = plantIndex;
    }



    public void printGrid() {
        printPartGrid(-3, 0);
        for (int i = 0; i < grid.length; i++) {
            if (i!=0){
                    if (i % 2 == 0) {
                        printPartGrid(-1, 0);
                    } else
                        printPartGrid(-4, 0);
            }
            printPartGrid(grid[i], i);
        }
        printPartGrid(-2, 0);
    }


        private void printPartGrid(int part, int i ) {
            if (part == -1) {
                System.out.println();
                System.out.println("|_____|_____|");
                System.out.println("|     |     |");
            } else if (part == -2) {
                System.out.println();
                System.out.println("|     |     |");
            }
            else if (part == -3) {
                System.out.println("|     |     |");
            }
            else if (part == -4) {
                System.out.print(" |");
            }else {
                if (part == 0) System.out.print("  " + i + "  ");
                if (part == 1) System.out.print("  X  ");
                if (part == 4) System.out.print("  O  ");
            }
    }
}
