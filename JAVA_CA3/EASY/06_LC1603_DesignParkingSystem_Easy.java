// LeetCode 1603 - Design Parking System
// Java focus: class, constructor, private fields, encapsulation, return values
class LC1603_DesignParkingSystem {
    private int bigSpaces;
    private int mediumSpaces;
    private int smallSpaces;

    public LC1603_DesignParkingSystem(int big, int medium, int small) {
        this.bigSpaces = big;
        this.mediumSpaces = medium;
        this.smallSpaces = small;
    }

    public boolean addCar(int carType) {
        if (carType == 1 && bigSpaces > 0) {
            bigSpaces--;
            return true;
        } else if (carType == 2 && mediumSpaces > 0) {
            mediumSpaces--;
            return true;
        } else if (carType == 3 && smallSpaces > 0) {
            smallSpaces--;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LC1603_DesignParkingSystem parking =
                new LC1603_DesignParkingSystem(1, 1, 0);
        System.out.println(parking.addCar(1)); // true
        System.out.println(parking.addCar(2)); // true
        System.out.println(parking.addCar(3)); // false
    }
}
