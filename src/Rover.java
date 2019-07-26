import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Rover implements Turnable, Moveable, ProgramFileAware{
    private List<RoverCommand> roverCommands = new ArrayList<>();
    private GroundVisor visor = new GroundVisor();
    private Direction direction = Direction.NORTH;
    private int x = 0;
    private int y = 0;


    public int getX(){
        return x;
    }

    public int getY() {
        return y;
    }

    public GroundVisor getVisor(){
        return visor;
    }

    public Direction getDirection(){
        return direction;
    }

    public void executeProgramFile(String filename){
        RoverCommandParser parser = new RoverCommandParser(this,filename);

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String command;
            while ((command = reader.readLine()) != null) {
                roverCommands.add(parser.readNextCommand(this,command));
            }


            for (RoverCommand roverCommand:roverCommands) {
                new LoggingCommand(roverCommand).execute();
            }

        } catch (IOException ex){
            System.out.println("Error while reading");
        }
    }

    public void move(int _x, int _y){
        try {
            if (!visor.hasObstacles(_x, _y)) {
                if(x<visor.getGround().getWidth()&y<visor.getGround().getLength()) {
                    visor.getGround().setCellState(x, y, CellState.FREE);
                }
                x = _x;
                y = _y;
                visor.getGround().setCellState(x,y,CellState.OCCUPIED);
            }
            else
                System.out.println("Cell (" + _x + "," + _y + ") isn't free");
        }
        catch (GroundVisorException ex){
            System.out.print(ex.getMessage());
            if(ex.getPoint()!= 0)
                 System.out.println(ex.getPoint());
        }
    }

    public void turnTo(Direction newDirection){
        direction = newDirection;
    }

    public void showLocation(){
        System.out.println("Rover location is (" + x + ", " + y + ')');
    }

    public void showDirection(){
        System.out.print("Rover direction is ");
        switch (direction)
        {
            case NORTH:
                System.out.print("NORTH"); break;
            case EAST:
                System.out.print("EAST"); break;
            case SOUTH:
                System.out.print("SOUTH"); break;
            case WEST:
                System.out.print("WEST"); break;
        }
        System.out.println();
    }

}
