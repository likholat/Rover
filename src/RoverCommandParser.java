import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RoverCommandParser {
    private Rover rover;
    private String string;

    public RoverCommandParser(Rover rover, String string) {
        this.rover = rover;
        this.string = string;
    }

    public RoverCommand readNextCommand(Rover rover, String commandName){

        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(commandName);
        int x = 0, y = 0;
        Direction direction = Direction.NORTH;

        if (commandName.startsWith("move(")) {
            if (m.find())
                x = Integer.parseInt(m.group());
            if (m.find())
                y = Integer.parseInt(m.group());
            Moveable moveable = rover;
            RoverCommand rc = new MoveCommand(moveable, x, y);
            return rc;
        } else if (commandName.startsWith("turnTo(")) {
            String turnArg = commandName.substring(commandName.indexOf("(") + 1, commandName.indexOf(")"));
            if (turnArg.startsWith("EA"))
                direction = Direction.EAST;
            else if (turnArg.startsWith("NO"))
                direction = Direction.NORTH;
            else if (turnArg.startsWith("WE"))
                direction = Direction.WEST;
            else if (turnArg.startsWith("SO"))
                direction = Direction.SOUTH;

            Turnable turnable = rover;
            RoverCommand rc = new TurnCommand(turnable, direction);
            return rc;
        } else if (commandName != null){
                RoverCommand rc = new ImportCommand(commandName,rover);
                return rc;
        }
        return null;
    }
}
