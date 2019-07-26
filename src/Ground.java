public class Ground {
    private GroundCell[][] landscape;
    private int length;
    private int width;

    public Ground() {
        length = 1;
        width = 1;
        landscape = new GroundCell[length][width];
    }

    public Ground(int _length, int _width) {
        length = _length;
        width = _width;
        landscape = new GroundCell[length][width];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                landscape[i][j] = new GroundCell(j, i, CellState.FREE);
            }
        }
    }

    public int getWidth(){
        return  width;
    }

    public int getLength(){
        return length;
    }

    public void occupyCell(int _x, int _y){
        landscape[_y][_x].setState(CellState.OCCUPIED);
    }

//    public void switchCellState(int _x, int _y){
//        if(landscape[_y][_x].getState() == CellState.FREE) {
//            landscape[_y][_x].setState(CellState.OCCUPIED);
//        }
//        if((landscape[_y][_x].getState() == CellState.OCCUPIED)){
//            landscape[_y][_x].setState(CellState.FREE);
//        }
//    }

    public CellState getCellState(int _x, int _y){
        return landscape[_y][_x].getState();
    }

    public void setCellState(int _x, int _y, CellState cellState){
        landscape[_y][_x].setState(cellState);
    }

    public void showGround(){
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if(landscape[i][j].getState() == CellState.FREE)
                    System.out.print("f" + "\t");
                else
                    System.out.print("o" + "\t");
            }
            System.out.println();
        }
    }

}