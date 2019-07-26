public class NewMain {
    public static void main(String[] args) throws Exception{
        Rover myRover = new Rover();
        myRover.getVisor().setGround(new Ground(5,4));

        myRover.executeProgramFile("task1.txt");

        myRover.showLocation();
        myRover.showDirection();
        myRover.getVisor().getGround().showGround();

    }
}
