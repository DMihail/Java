public class Aging extends Thread {
    private int time;
    private int index;
    private  Grid grid = new Grid();

    public void setTimeAndIndex(int time, int index) {
        this.time = time;
        this.index = index;
    }

    private void setPlantOfTheGrid(String status) {
        grid.setPlantOfTheGrid(index, status);
    }

    public  void  run() {
        try {
            setPlantOfTheGrid("З");
//            grid.printGrid();
            Thread.sleep(time);
//            System.out.println("Растение в ячейке " + index + " созрело, соберите урожай");
            setPlantOfTheGrid("У");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
