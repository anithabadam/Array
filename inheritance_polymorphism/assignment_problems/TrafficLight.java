package inheritance_polymorphism.assignment_problems;

public class TrafficLight {

    private String color;

    // Constructor
    public TrafficLight(String color) {
        this.color = color;
    }

    // Change to next color
    public void next() {
        if (color.equals("RED")) {
            color = "GREEN";
        } 
        else if (color.equals("GREEN")) {
            color = "YELLOW";
        } 
        else if (color.equals("YELLOW")) {
            color = "RED";
        }
    }

    // Get current color
    public String getColor() {
        return color;
    }

    // Main method
    public static void main(String[] args) {

        TrafficLight light = new TrafficLight("RED");

        System.out.println(light.getColor());

        light.next();
        System.out.println(light.getColor());

        light.next();
        System.out.println(light.getColor());

        light.next();
        System.out.println(light.getColor());
    }
}