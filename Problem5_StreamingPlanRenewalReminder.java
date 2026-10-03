import java.time.LocalDate;
import java.util.Scanner;

public class Problem5_StreamingPlanRenewalReminder {

    static abstract class Plan {
        String name;
        LocalDate startDate;

        Plan(String name, LocalDate startDate) {
            this.name = name;
            this.startDate = startDate;
        }

        abstract int getValidityDays();

        LocalDate getRenewalDate() {
            return startDate.plusDays(getValidityDays());
        }
    }

    static class Basic extends Plan {

        Basic(String name, LocalDate startDate) {
            super(name, startDate);
        }

        int getValidityDays() {
            return 30;
        }
    }

    static class Standard extends Plan {

        Standard(String name, LocalDate startDate) {
            super(name, startDate);
        }

        int getValidityDays() {
            return 90;
        }
    }

    static class Premium extends Plan {

        Premium(String name, LocalDate startDate) {
            super(name, startDate);
        }

        int getValidityDays() {
            return 365;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();
            LocalDate startDate = LocalDate.parse(sc.next());

            Plan plan;

            if (type.equals("BASIC")) {
                plan = new Basic(name, startDate);

            } else if (type.equals("STANDARD")) {
                plan = new Standard(name, startDate);

            } else {
                plan = new Premium(name, startDate);
            }

            System.out.println(
                plan.name + ": " + plan.getRenewalDate()
            );
        }

        sc.close();
    }
}
