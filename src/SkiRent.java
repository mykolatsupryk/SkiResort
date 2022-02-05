public class SkiRent {

    private static int rentSki() {
        return 100;
    }

    private static int rentBoots() {
        return 60;
    }

    private static int rentPole() {
        return 40;
    }

    public static int rentEquipment() {
        return rentBoots() + rentSki() + rentPole();
    }


}
