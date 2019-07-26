public class LoggingCommand implements RoverCommand {
    private RoverCommand command;

    public LoggingCommand(RoverCommand command){
        this.command = command;
    }

    @Override
    public void execute() {
        if(command.getClass().toString().equalsIgnoreCase( "class MoveCommand"))
            System.out.println("MoveCommand");
        if(command.getClass().toString().equalsIgnoreCase( "class ImportCommand"))
            System.out.println("ImportFileCommand");
        if(command.getClass().toString().equalsIgnoreCase( "class TurnCommand"))
            System.out.println("TurnToCommand");
        command.execute();
    }
}
