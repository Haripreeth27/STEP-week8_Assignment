import java.util.Scanner;

public class Problem3_HostelElectricityBill {

    static abstract class Room {
        int units;

        Room(int units) {
            this.units = units;
        }

        abstract double getBill();
    }

    static class Single extends Room {

        Single(int units) {
            super(units);
        }

        double getBill() {
            return units * 8;
        }
    }

    static class Shared extends Room {

        int occupants;

        Shared(int units, int occupants) {
            super(units);
            this.occupants = occupants;
        }

        double getBill() {
            return (units * 6) / (double) occupants;
        }
    }

    static class AC extends Room {

        AC(int units) {
            super(units);
        }

        double getBill() {
            return (units * 10) + 200;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            int units = sc.nextInt();

            Room room;

            if (type.equals("SINGLE")) {
                room = new Single(units);

            } else if (type.equals("SHARED")) {
                int occupants = sc.nextInt();
                room = new Shared(units, occupants);

            } else {
                room = new AC(units);
            }

            double bill = room.getBill();

            System.out.printf(
                "%s: %.2f%n",
                type,
                bill
            );

            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}

