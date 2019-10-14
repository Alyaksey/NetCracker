public class Flat {
    private double area;
    private int numberOfRooms;

    private final static int DEFAULT_NUMBER_OF_ROOMS = 2;
    private final static double DEFAULT_AREA = 50.0;

    public Flat() {
        this(DEFAULT_AREA, DEFAULT_NUMBER_OF_ROOMS);
    }

    public Flat(double area) {
        this(area, DEFAULT_NUMBER_OF_ROOMS);
    }

    public Flat(double area, int numberOfRooms) {
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Flat{");
        sb.append("area=").append(area);
        sb.append(", numberOfRooms=").append(numberOfRooms);
        sb.append('}');
        return sb.toString();
    }
}
