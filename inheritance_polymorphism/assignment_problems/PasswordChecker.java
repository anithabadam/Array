package inheritance_polymorphism.assignment_problems;

public class PasswordChecker {

    private String password;

    // Constructor
    public PasswordChecker(String password) {
        this.password = password;
    }

    // Return password strength
    public String getStrength() {

        if (password.length() < 6) {
            return "Weak";
        } 
        else if (password.length() < 10) {
            return "Medium";
        } 
        else {
            return "Strong";
        }
    }

    // Main method
    public static void main(String[] args) {

        PasswordChecker p = new PasswordChecker("Hello123");

        System.out.println("Password strength: " + p.getStrength());
    }
}