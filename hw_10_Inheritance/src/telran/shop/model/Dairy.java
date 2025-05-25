package telran.shop.model;

public class Dairy extends Food {
    String typeOfMilk;
    double fat;

    public Dairy(long barcode, String name, double price, boolean kosher, String dateExp, String typeOfMilk, double fat) {
        super(barcode, name, price, kosher, dateExp);
        this.typeOfMilk = typeOfMilk;
        this.fat = fat;
    }

    public String getTypeOfMilk() {
        return typeOfMilk;
    }

    public void setTypeOfMilk(String typeOfMilk) {
        this.typeOfMilk = typeOfMilk;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Type of milk: " + typeOfMilk +
                ", Fat: " + fat;

    }
}
