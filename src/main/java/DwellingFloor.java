public class DwellingFloor {
    private Flat[] flats;

    public DwellingFloor(int flatsQuantity) {
        this.flats = new Flat[flatsQuantity];
        for (int i = 0; i < flatsQuantity; i++) {
            flats[i] = new Flat();
        }
    }

    public DwellingFloor(Flat[] flats) {
        this.flats = new Flat[flats.length];
        System.arraycopy(flats, 0, this.flats, 0, flats.length);
    }

    public int size() {
        return this.flats.length;
    }

    public int getTotalAreaOfFlats() {
        int totalAreaOfFlats = 0;
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
        Flat[] copiedFlats = new Flat[flats.length];
        System.arraycopy(this.flats, 0, copiedFlats, 0, this.flats.length);
        return copiedFlats;
    }

    public Flat getFlat(int flatNumber) {
        return flats[flatNumber];
    }

    public void changeFlat(int flatNumber, Flat flat) {
        flats[flatNumber] = flat;
    }

    public void addFlat(int flatNumber, Flat flat) {
        increaseCapacity();
        this.flats[flatNumber] = flat;
    }

    private void increaseCapacity() {
        Flat[] newFlats = new Flat[this.flats.length + 1];
        System.arraycopy(this.flats, 0, newFlats, 0, this.flats.length);
        this.flats = newFlats;
    }

}
