package telran.shop.model;

public class Meat extends Food {
    String typeOfMeat;

    public Meat(long barcode, String name, double price, boolean kosher, String dateExp, String typeOfMeat) {
        super(barcode, name, price, kosher, dateExp);
        this.typeOfMeat = typeOfMeat;
    }

    public String getTypeOfMeat() {
        return typeOfMeat;
    }

    public void setTypeOfMeat(String typeOfMeat) {
        this.typeOfMeat = typeOfMeat;
    }

    @Override
    public String toString() {
        return super.toString() + "Type of meat: " + typeOfMeat;
    }
}
