package polymorphism.assignment_problem;

import java.util.Scanner;

abstract class Room {
    protected double units;

    Room(double units) {
        this.units = units;
    }

    abstract double calculateBill();

    abstract String getType();
}

class SingleRoom extends Room {

    SingleRoom(double units) {
        super(units);
    }

    @Override
    double calculateBill() {
        return units * 8.0;
    }

    @Override
    String getType() {
        return "SINGLE";
    }
}

class SharedRoom extends Room {
    private int occupants;

    SharedRoom(double units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    @Override
    double calculateBill() {
        return (units * 6.0) / occupants;
    }

    @Override
    String getType() {
        return "SHARED";
    }
}

class ACRoom extends Room {

    ACRoom(double units) {
        super(units);
    }

    @Override
    double calculateBill() {
        return units * 10.0 + 200.0;
    }

    @Override
    String getType() {
        return "AC";
    }
}

public class HostelElectricity {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0.0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double units = sc.nextDouble();

            Room room;

            if (type.equals("SINGLE")) {
                room = new SingleRoom(units);

            } else if (type.equals("SHARED")) {
                int occupants = sc.nextInt();
                room = new SharedRoom(units, occupants);

            } else {
                room = new ACRoom(units);
            }

            double bill = room.calculateBill();
            total += bill;

            System.out.printf("%s: %.2f%n",
                    room.getType(), bill);
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}