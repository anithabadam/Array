package polymorphism.assignment_problem;

import java.time.LocalDate;
import java.util.Scanner;

abstract class Plan {
    protected String name;
    protected LocalDate startDate;

    Plan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    abstract int getValidityDays();

    LocalDate getRenewalDate() {
        return startDate.plusDays(getValidityDays());
    }
}

class BasicPlan extends Plan {

    BasicPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    int getValidityDays() {
        return 30;
    }
}

class StandardPlan extends Plan {

    StandardPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    int getValidityDays() {
        return 90;
    }
}

class PremiumPlan extends Plan {

    PremiumPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    int getValidityDays() {
        return 365;
    }
}

public class StreamingRenewal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();
            LocalDate startDate = LocalDate.parse(sc.next());

            Plan plan;

            if (type.equals("BASIC")) {
                plan = new BasicPlan(name, startDate);
            } else if (type.equals("STANDARD")) {
                plan = new StandardPlan(name, startDate);
            } else {
                plan = new PremiumPlan(name, startDate);
            }

            System.out.println(
                plan.name + ": " + plan.getRenewalDate()
            );
        }

        sc.close();
    }
}