package Week_6;

public class EmployeeM5 {

    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    // Constructor
    EmployeeM5(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    // Static method
    static void printCompanyInfo() {
        System.out.println("Company: " + companyName);
        System.out.println("Employee Count: " + employeeCount);
    }

    public static void main(String[] args) {

        EmployeeM5 e1 = new EmployeeM5("Rahul", 45000);
        EmployeeM5 e2 = new EmployeeM5("Priya", 50000);
        EmployeeM5 e3 = new EmployeeM5("Arjun", 55000);

        EmployeeM5.printCompanyInfo();
    }
}