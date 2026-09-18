package Week_6;

public class PayrollSalaryManagement {

    private double basicSalary;
    private double bonus;

    // Constructor
    public PayrollSalaryManagement(double basicSalary, double bonus) {

        if (basicSalary < 0) {
            this.basicSalary = 0;
            System.out.println("Warning: Negative basic salary set to 0");
        } else {
            this.basicSalary = basicSalary;
        }

        if (bonus < 0) {
            this.bonus = 0;
            System.out.println("Warning: Negative bonus set to 0");
        } else {
            this.bonus = bonus;
        }
    }

    // Add bonus
    public void creditBonus(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid bonus amount");
        } else {
            bonus += amount;
        }
    }

    // Deduct tax
    public void deductTax(double percent) {

        if (percent < 0 || percent > 100) {
            System.out.println("Invalid tax percentage");
        } else {
            basicSalary = basicSalary - (basicSalary * percent / 100);
        }
    }

    // Get net salary
    public double getNetSalary() {
        return basicSalary + bonus;
    }

    // Main method
    public static void main(String[] args) {

        PayrollSalaryManagement p =
            new PayrollSalaryManagement(50000, 5000);

        System.out.println("Initial Net Salary: " + p.getNetSalary());

        p.creditBonus(2000);
        System.out.println("After Bonus: " + p.getNetSalary());

        p.deductTax(10);
        System.out.println("After 10% Tax: " + p.getNetSalary());

        p.creditBonus(-500);
        p.deductTax(120);

        System.out.println("Final Net Salary: " + p.getNetSalary());
    }
}