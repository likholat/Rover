public class GroundVisor {
    private Ground ground;

    public void setGround(Ground ground) {
        this.ground = ground;
    }

    public Ground getGround(){
        return ground;
    }

    public boolean hasObstacles(int x, int y) throws GroundVisorException {
        if (x >= ground.getWidth() || x < 0)
            throw new GroundVisorException("Width is incorrect: ", x);
        if (y >= ground.getLength() || y < 0)
            throw new GroundVisorException("Length is incorrect: ", y);
        if (ground.getCellState(x, y) == CellState.OCCUPIED)
            return true;
        else return false;
    }

}
