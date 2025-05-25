package telran.computer.model;

public class Smartphone extends Laptop {

    private long imei;

    public Smartphone(String cpu, int ram, int ssd, String brand, double weight, double hours, long imei) {
        super(cpu, ram, ssd, brand, weight, hours);
        this.imei = imei;
    }

    public long getImei() {
        return imei;
    }

    @Override
    public void display() {
        super.display();
        System.out.println(", IMAI: " + imei);
    }
}
