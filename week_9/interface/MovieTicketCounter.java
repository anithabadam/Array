import java.util.Scanner;

interface Ticket {
    double getPrice();
}

class RegularTicket implements Ticket {
    public double getPrice() {
        return 150;
    }
}

class PremiumTicket implements Ticket {
    public double getPrice() {
        return 250;
    }
}

class ReclinerTicket implements Ticket {
    public double getPrice() {
        return 400;
    }
}

public class MovieTicketCounter {
    private static final double CONVENIENCE_FEE = 20.0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String seat = sc.next();
            int count = sc.nextInt();

            Ticket ticket;

            switch (seat) {
                case "REGULAR":
                    ticket = new RegularTicket();
                    break;
                case "PREMIUM":
                    ticket = new PremiumTicket();
                    break;
                case "RECLINER":
                    ticket = new ReclinerTicket();
                    break;
                default:
                    continue;
            }

            double amount = count * (ticket.getPrice() + CONVENIENCE_FEE);
            total += amount;

            System.out.printf("%s: %.2f%n", seat, amount);
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}