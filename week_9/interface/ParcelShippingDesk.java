import java.util.Scanner;

interface Parcel {
    double getCharge();
    double getInsurance();
}

class StandardParcel implements Parcel {
    private double weight;

    StandardParcel(double weight) {
        this.weight = weight;
    }

    public double getCharge() {
        return 40 + (10 * weight);
    }

    public double getInsurance() {
        return 0;
    }
}

class ExpressParcel implements Parcel {
    private double weight;
    private double declaredValue;

    ExpressParcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    public double getCharge() {
        return 80 + (15 * weight);
    }

    public double getInsurance() {
        return declaredValue * 0.02;
    }
}

class FragileParcel implements Parcel {
    private double weight;
    private double declaredValue;

    FragileParcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    public double getCharge() {
        return 40 + (10 * weight) + 50;
    }

    public double getInsurance() {
        return declaredValue * 0.02;
    }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double declaredValue = sc.nextDouble();

            Parcel parcel;

            switch (type) {
                case "STANDARD":
                    parcel = new StandardParcel(weight);
                    break;

                case "EXPRESS":
                    parcel = new ExpressParcel(weight, declaredValue);
                    break;

                case "FRAGILE":
                    parcel = new FragileParcel(weight, declaredValue);
                    break;

                default:
                    continue;
            }

            double charge = parcel.getCharge();
            double insurance = parcel.getInsurance();
            double total = charge + insurance;

            grandTotal += total;

            System.out.printf(
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                type, charge, insurance, total
            );
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);

        sc.close();
    }
}
