public class GroundCell {
    private CellState state;
    private int x;
    private int y;

    public GroundCell(){}
    public GroundCell(int _x, int _y, CellState _state){
        x = _x;
        y = _y;
        state = _state;
    }

    public void setState(CellState _state){
        state = _state;
    }

    public CellState getState(){
        return state;
    }

    public void switchState(){
        if(state == CellState.FREE)
            state = CellState.OCCUPIED;
        else
            state = CellState.FREE;
    }
}
