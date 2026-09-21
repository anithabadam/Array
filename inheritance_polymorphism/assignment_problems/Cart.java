package inheritance_polymorphism.assignment_problems;

public class Cart {

    private double[] prices;

    // Constructor
    public Cart(double[] prices) {
        this.prices = prices;
    }

    // Add item
    public void addItem(double price) {
        double[] newPrices = new double[prices.length + 1];

        for (int i = 0; i < prices.length; i++) {
            newPrices[i] = prices[i];
        }

        newPrices[prices.length] = price;
        prices = newPrices;
    }

    // Get total price
    public double getTotal() {
        double total = 0;

        for (double price : prices) {
            total += price;
        }

        return total;
    }

    // Get number of items
    public int getItemCount() {
        return prices.length;
    }

    // Main method
    public static void main(String[] args) {

        double[] initialPrices = {100.0, 200.0};

        Cart cart = new Cart(initialPrices);

        cart.addItem(150.0);

        System.out.println("Total: " + cart.getTotal());
        System.out.println("Item count: " + cart.getItemCount());
    }
}