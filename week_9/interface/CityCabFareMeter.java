import java.util.Scanner;

interface Cab {
    double getRate();
    boolean nightService();
}

class Mini implements Cab {
    public double getRate() {
        return 10;
    }

    public boolean nightService() {
        return false;
    }
}

class Sedan implements Cab {
    public double getRate() {
        return 14;
    }

    public boolean nightService() {
        return true;
    }
}

class SUV implements Cab {
    public double getRate() {
        return 18;
    }

    public boolean nightService() {
        return true;
    }
}

public class CityCabFareMeter {

    private static final double MINIMUM_FARE = 100.0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab cab;

            switch (type) {
                case "MINI":
                    cab = new Mini();
                    break;

                case "SEDAN":
                    cab = new Sedan();
                    break;

                case "SUV":
                    cab = new SUV();
                    break;

                default:
                    continue;
            }

            if (time.equals("NIGHT") && !cab.nightService()) {
                System.out.println(type + ": night service not available");
                continue;
            }

            double fare = km * cab.getRate();

            if (fare < MINIMUM_FARE) {
                fare = MINIMUM_FARE;
            }

            if (time.equals("NIGHT")) {
                fare = fare * 1.20;
            }

            total += fare;

            System.out.printf("%s: %.2f%n", type, fare);
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}