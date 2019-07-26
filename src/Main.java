public class Main {
    public static void main(String[] args) {

        //создали ровер, поле
        //подвинули на хорошую позицию, развернули
        Rover myRover = new Rover();
        myRover.getVisor().setGround(new Ground(5,4));
        myRover.move(2,3);
        myRover.showLocation();
        myRover.turnTo(Direction.EAST);
        myRover.showDirection();

        //пытаемся подвинуть за пределы поля
        myRover.move(7,3);
        myRover.showLocation();

        //поставили препятствие, попытались туда передвинуться
        myRover.getVisor().getGround().occupyCell(1,1);
        myRover.move(1,1);
        myRover.showLocation();

        myRover.getVisor().getGround().showGround();
    }
}
