public class MoveCommand implements  RoverCommand{
    private Moveable moveable;
    private int x;
    private int y;

    public MoveCommand(Moveable moveable, int x, int y){
        this.moveable = moveable;
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute() {
        moveable.move(x,y);
    }
}
