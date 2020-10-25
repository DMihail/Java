package util;
import game.*;

public class Aging extends Thread {
    private int time;
    private int index;
    private Grid grid;

    public void setTimeAndIndex(int time, int index, Grid grid) {
        this.time = time;
        this.index = index;
        this.grid = grid;
    }

    private void setPlantOfTheGrid(String status) {
        grid.setPlantOfTheGrid(index, status);
    }

    public  void  run() {
        try {
            setPlantOfTheGrid("З");
            Thread.sleep(time);
            System.out.println("Растение в ячейке " + index + " созрело, соберите урожай");
            setPlantOfTheGrid("У");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
