import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Flat flat0 = new Flat(25.0, 4);
        Flat flat1 = new Flat(22.0, 3);
        Flat flat2 = new Flat(38.0, 7);
        Flat flat3 = new Flat(64.0, 3);
        Flat flat4 = new Flat(35.0, 4);
        Flat flat5 = new Flat(87.0, 5);
        Flat flat6 = new Flat(11.0, 3);
        Flat flat7 = new Flat(95.0, 9);
        Flat flat8 = new Flat(45.0, 1);
        DwellingFloor floor0 = new DwellingFloor(new Flat[]{flat0, flat1, flat2});
        DwellingFloor floor1 = new DwellingFloor(new Flat[]{flat3, flat4});
        DwellingFloor floor2 = new DwellingFloor(new Flat[]{flat5, flat6, flat7, flat8});
        System.out.println(floor0.getBestSpace());
        System.out.println(floor0.getNumberOfFlats());
        System.out.println(Arrays.toString(floor0.getFlats()));
        System.out.println(floor0.getFlat(2));
        System.out.println(floor0.getTotalAreaOfFlats());
        System.out.println(floor0.getTotalNumberOfRooms());
        floor0.addFlat(1, new Flat());
        System.out.println(Arrays.toString(floor0.getFlats()));
        floor0.removeFlat(1);
        System.out.println(Arrays.toString(floor0.getFlats()));
        floor0.setFlat(0, new Flat());
        System.out.println(Arrays.toString(floor0.getFlats()));
        Dwelling dwelling = new Dwelling(new DwellingFloor[] {floor0, floor1, floor2});
        System.out.println(dwelling.getNumberOfFloors());
        System.out.println(dwelling.getTotalNumberOfFlats());
        System.out.println(dwelling.getTotalNumberOfRooms());
        System.out.println(dwelling.getTotalArea());
        System.out.println(Arrays.toString(dwelling.getFloors()));
        System.out.println(dwelling.getFloor(2));
        System.out.println(dwelling.getFlat(6));
        System.out.println(Arrays.toString(dwelling.getSortedFlatsByDesc()));
    }
}
