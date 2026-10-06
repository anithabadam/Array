import java.util.Scanner;

interface Appliance {
    double getPower();
}

interface SaverMode {
    boolean supportsSaver();
}

class Fridge implements Appliance {
    public double getPower() {
        return 150;
    }
}

class AC implements Appliance, SaverMode {
    public double getPower() {
        return 1500;
    }

    public boolean supportsSaver() {
        return true;
    }
}

class TV implements Appliance {
    public double getPower() {
        return 100;
    }
}

class Washer implements Appliance, SaverMode {
    public double getPower() {
        return 500;
    }

    public boolean supportsSaver() {
        return true;
    }
}

public class HomeApplianceEnergyReport {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalCost = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double hours = sc.nextDouble();

            boolean saver = false;

            if (sc.hasNext("SAVER")) {
                sc.next();
                saver = true;
            }

            Appliance appliance;

            switch (type) {
                case "FRIDGE":
                    appliance = new Fridge();
                    break;

                case "AC":
                    appliance = new AC();
                    break;

                case "TV":
                    appliance = new TV();
                    break;

                case "WASHER":
                    appliance = new Washer();
                    break;

                default:
                    continue;
            }

            if (saver && !(appliance instanceof SaverMode)) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }

            double units = (appliance.getPower() * hours) / 1000;

            if (saver) {
                units = units * 0.75;
            }

            double cost = units * 8;
            totalCost += cost;

            System.out.printf(
                "%s: Units=%.2f Cost=%.2f%n",
                type, units, cost
            );
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);

        sc.close();
    }
}