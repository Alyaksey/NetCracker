public class Flat {
    private int area;
    private int numberOfRooms;

    private final static int DEFAULT_NUMBER_OF_ROOMS = 2;
    private final static int DEFAULT_AREA = 50;

    public Flat() {
        this(DEFAULT_AREA, DEFAULT_NUMBER_OF_ROOMS);
    }

    public Flat(int area) {
        this(area, DEFAULT_NUMBER_OF_ROOMS);
    }

    public Flat(int area, int numberOfRooms) {
        this.area = area;
        this.numberOfRooms = numberOfRooms;
    }

    public double getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }
}
