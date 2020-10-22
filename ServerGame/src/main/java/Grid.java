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
            }
    }

    private void printPartGrid(String part, int i ) {
                System.out.print("  " + part + "  ");
    }
}
