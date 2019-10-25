import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImportCommand implements RoverCommand {
    private List<RoverCommand> roverCommandList;
    private String filename;
    private Rover rover;

    @Override
    public void execute() {
        RoverCommandParser parser = new RoverCommandParser(rover,filename);

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String command;
            while ((command = reader.readLine()) != null) {
                roverCommandList.add(parser.readNextCommand(rover, command));
            }
        } catch (IOException ex){System.out.println("Split error");}


        for (RoverCommand roverCommand : roverCommandList) {
            new LoggingCommand(roverCommand).execute();
        }
    }

    ImportCommand(String filename, Rover rover){
        roverCommandList = new ArrayList<>();
        this.filename = filename;
        this.rover = rover;
    }
}
