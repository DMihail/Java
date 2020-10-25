package game;

public class Grid {

private String [] grid = { " ", " ",
                           " ", " ",
                           " ", " ",
                           " ", " ", };


    public void setPlantOfTheGrid(int numPart, String plantIndex) {
        grid[numPart] = plantIndex;
    }

    public boolean isPartGridEmpty(int index) {
        if (grid[index] == " ") {
            return true;
        }
        return false;
    }

    public boolean isPlantRipe(int index) {
        if (grid[index] == "У") {
            return true;
        } else if (grid[index] == "З"){
            System.out.println("Растение зреет");
        } else {
            System.out.println("Ячейка пуста");
        }
        return false;
    }

    public void printGrid() {
        printPartGrid(-3);
        for (int i = 0; i < grid.length; i++) {
            if (i!=0){
                    if (i % 2 == 0) {
                        printPartGrid(-1);
                    } else
                        printPartGrid(-4);
            }
            printPartGrid(grid[i], i);
        }
        printPartGrid(-2);
    }


        private void printPartGrid(int part ) {
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
            }
    }

    private void printPartGrid(String part, int i ) {
                System.out.print("  " + part + "  ");
    }
}
