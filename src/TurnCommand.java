public class TurnCommand implements RoverCommand {
    private Turnable turnable;
    private Direction direction;

    public TurnCommand(Turnable turnable,Direction direction){
        this.turnable = turnable;
        this.direction = direction;
    }

    @Override
    public void execute() {
            turnable.turnTo(direction);
    }
}
