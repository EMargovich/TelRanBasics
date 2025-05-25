package telran.computer.model;

public class Laptop extends Computer {
    private double weight;
    private double hours;

    public Laptop(String cpu, int ram, int ssd, String brand, double weight, double hours) {
        super(cpu, ram, ssd, brand);
        this.weight = weight;
        this.hours = hours;

    }

    public double getWeight() {
        return weight;
    }

    public double getHours() {
        return hours;
    }

    @Override
    public void display() {
        super.display();
        System.out.print(", Weight: " + weight + ", Hours: " + hours );
    }
}