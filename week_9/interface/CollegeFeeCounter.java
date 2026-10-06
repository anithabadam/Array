import java.util.Scanner;

interface Student {
    double getTuition();

    boolean usesBus();
}

class DayScholar implements Student {
    public double getTuition() {
        return 40000;
    }

    public boolean usesBus() {
        return true;
    }
}

class Hosteller implements Student {
    public double getTuition() {
        return 40000 + 60000;
    }

    public boolean usesBus() {
        return false;
    }
}

class Scholar implements Student {
    public double getTuition() {
        return 20000;
    }

    public boolean usesBus() {
        return true;
    }
}

public class CollegeFeeCounter {

    private static final double TRANSPORT_FEE = 12000;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalCollected = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();

            Student student;

            switch (type) {
                case "DAY_SCHOLAR":
                    student = new DayScholar();
                    break;

                case "HOSTELLER":
                    student = new Hosteller();
                    break;

                case "SCHOLAR":
                    student = new Scholar();
                    break;

                default:
                    continue;
            }

            double fee = student.getTuition();

            if (student.usesBus()) {
                fee += TRANSPORT_FEE;
            }

            totalCollected += fee;

            System.out.printf("%s: %.2f%n", name, fee);
        }

        System.out.printf("Total Collected: %.2f%n", totalCollected);

        sc.close();
    }
}