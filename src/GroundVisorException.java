public class GroundVisorException extends RuntimeException {
    private int point;

    public int getPoint() {
        return point;
    }

    public GroundVisorException(String message, int wrongPoint) {
       // throw new RuntimeException();
        super(message);
        point = wrongPoint;
    }
}