import java.util.Arrays;

public class Dwelling {
    private DwellingFloor[] floors;

    public Dwelling(int numberOfFloors, int[] numbersOfFlats) {
        if (numberOfFloors != numbersOfFlats.length) throw new IndexOutOfBoundsException();
        floors = new DwellingFloor[numberOfFloors];
        for (int i = 0; i < numberOfFloors; i++) {
            floors[i] = new DwellingFloor(numbersOfFlats[i]);
        }
    }

    public Dwelling(DwellingFloor[] floors) {
        this.floors = new DwellingFloor[floors.length];
        System.arraycopy(floors, 0, this.floors, 0, floors.length);
    }

    public int getNumberOfFloors() {
        return floors.length;
    }

    public int getTotalNumberOfFlats() {
        int totalNumberOfFlats = 0;
        for (DwellingFloor floor : floors)
            totalNumberOfFlats += floor.getNumberOfFlats();
        return totalNumberOfFlats;
    }

    public double getTotalArea() {
        double totalArea = 0.0;
        for (DwellingFloor floor : floors)
            totalArea += floor.getTotalAreaOfFlats();
        return totalArea;
    }

    public int getTotalNumberOfRooms() {
        int totalNumberOfRooms = 0;
        for (DwellingFloor floor : floors)
            totalNumberOfRooms += floor.getTotalNumberOfRooms();
        return totalNumberOfRooms;
    }

    public DwellingFloor[] getFloors() {
        DwellingFloor[] copiedFloors = new DwellingFloor[getNumberOfFloors()];
        System.arraycopy(this.floors, 0, copiedFloors, 0, getNumberOfFloors());
        return copiedFloors;
    }

    public DwellingFloor getFloor(int floorNumber) {
        return new DwellingFloor(floors[floorNumber].getFlats());
    }

    public void setFloor(int numberOfFloor, DwellingFloor floor) {
        floors[numberOfFloor] = floor;
    }

    public Flat getFlat(int flatNumber) {
        int flatsCount = 0;
        for (int i = 0; i < floors.length; i++) {
            for (int j = 0; j < floors[i].getNumberOfFlats(); j++) {
                if (flatNumber == flatsCount) {
                    return floors[i].getFlat(j);
                }
                flatsCount++;
            }
        }
        return null;
    }

    public void setFlat(int flatNumber, Flat flat) {
        int flatsCount = 0;
        for (int i = 0; i < floors.length; i++) {
            for (int j = 0; j < floors[i].getNumberOfFlats(); j++) {
                if (flatNumber == flatsCount) {
                    floors[i].setFlat(j, flat);
                }
                flatsCount++;
            }
        }
    }

    public void addFlat(int flatNumber, Flat flat) {
        int flatsCount = 0;
        for (int i = 0; i < floors.length; i++) {
            for (int j = 0; j < floors[i].getNumberOfFlats(); j++) {
                if (flatNumber == flatsCount) {
                    floors[i].addFlat(j, flat);
                }
                flatsCount++;
            }
        }
    }

    public void removeFlat(int flatNumber) {
        int flatsCount = 0;
        for (int i = 0; i < floors.length; i++) {
            for (int j = 0; j < floors[i].getNumberOfFlats(); j++) {
                if (flatNumber == flatsCount) {
                    floors[i].removeFlat(j);
                }
                flatsCount++;
            }
        }
    }

    public Flat[] getSortedFlatsByDesc() {
        Flat[] sortedFlats = new Flat[getTotalNumberOfFlats()];
        Flat[] flatsOnFloor;
        int addedFlatsCounter = 0;
        for (int i = 0; i < floors.length; i++) {
            flatsOnFloor = floors[i].getFlats();
            System.arraycopy(flatsOnFloor, 0, sortedFlats, addedFlatsCounter, flatsOnFloor.length);
            addedFlatsCounter += flatsOnFloor.length;
        }
        mergeSort(sortedFlats);
        return sortedFlats;
    }

    private void mergeSort(Flat[] flats) {
        if (flats.length < 2)
            return;
        int mid = flats.length / 2;
        Flat[] leftArray = new Flat[mid];
        Flat[] rightArray = new Flat[flats.length - mid];
        System.arraycopy(flats, 0, leftArray, 0, leftArray.length);
        System.arraycopy(flats, leftArray.length, rightArray, 0, rightArray.length);
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(flats, leftArray, rightArray);
    }

    private void merge(Flat[] flats, Flat[] leftArray, Flat[] rightArray) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i].getArea() >= rightArray[j].getArea()) {
                flats[k++] = leftArray[i++];
            } else {
                flats[k++] = rightArray[j++];
            }
        }
        while (i < leftArray.length) {
            flats[k++] = leftArray[i++];
        }
        while (j < rightArray.length) {
            flats[k++] = rightArray[j++];
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Dwelling{");
        sb.append("floors=").append(Arrays.toString(floors));
        sb.append('}');
        return sb.toString();
    }
}
