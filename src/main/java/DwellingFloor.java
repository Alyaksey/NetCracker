import java.util.Arrays;

public class DwellingFloor {
    private Flat[] flats;

    public DwellingFloor(int numberOfFlats) {
        this.flats = new Flat[numberOfFlats];
        for (int i = 0; i < numberOfFlats; i++) {
            flats[i] = new Flat();
        }
    }

    public DwellingFloor(Flat[] flats) {
        this.flats = new Flat[flats.length];
        System.arraycopy(flats, 0, this.flats, 0, flats.length);
    }

    public int getNumberOfFlats() {
        return flats.length;
    }

    public double getTotalAreaOfFlats() {
        double totalAreaOfFlats = 0.0;
        for (Flat flat : flats) {
            totalAreaOfFlats += flat.getArea();
        }
        return totalAreaOfFlats;
    }

    public int getTotalNumberOfRooms() {
        int totalAreaOfRooms = 0;
        for (Flat flat : flats) {
            totalAreaOfRooms += flat.getNumberOfRooms();
        }
        return totalAreaOfRooms;
    }

    public Flat[] getFlats() {
        Flat[] copiedFlats = new Flat[getNumberOfFlats()];
        System.arraycopy(this.flats, 0, copiedFlats, 0, getNumberOfFlats());
        return copiedFlats;
    }

    public Flat getFlat(int flatNumber) {
        return new Flat(flats[flatNumber].getArea(), flats[flatNumber].getNumberOfRooms());
    }

    public void setFlat(int flatNumber, Flat flat) {
        flats[flatNumber] = flat;
    }

    public void addFlat(int flatNumber, Flat flat) {
        increaseCapacity();
        if (flatNumber == getNumberOfFlats() - 1) {
            flats[getNumberOfFlats() - 1] = flat;
        } else {
            System.arraycopy(flats, flatNumber, flats, flatNumber + 1, getNumberOfFlats()-flatNumber-1);
            flats[flatNumber] = flat;
        }
    }

    public void removeFlat(int flatNumber){
        Flat[] newFlats = new Flat[getNumberOfFlats() - 1];
        System.arraycopy(flats,0,newFlats,0, flatNumber);
        System.arraycopy(flats, flatNumber + 1, newFlats, flatNumber, getNumberOfFlats() - flatNumber - 1);
        this.flats = newFlats;
    }

    public Flat getBestSpace(){
        Flat bestSpace = new Flat(0.0);
        for (Flat flat: flats) {
            if (flat.getArea() > bestSpace.getArea()){
                bestSpace = flat;
            }
        }
        return bestSpace;
    }

    private void increaseCapacity() {
        Flat[] newFlats = new Flat[getNumberOfFlats() + 1];
        System.arraycopy(this.flats, 0, newFlats, 0, getNumberOfFlats());
        this.flats = newFlats;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DwellingFloor{");
        sb.append("flats=").append(Arrays.toString(flats));
        sb.append('}');
        return sb.toString();
    }
}
