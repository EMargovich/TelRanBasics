package telran.shop.model;

public class Food extends Product {
    boolean kosher;
    String dateExp;

    public Food(long barcode, String name, double price, boolean kosher, String dateExp) {
        super(barcode, name, price);
        this.kosher = kosher;
        this.dateExp = dateExp;
    }

    public boolean isKosher() {
        return kosher;
    }

    public void setKosher(boolean kosher) {
        this.kosher = kosher;
    }

    public String getDateExp() {
        return dateExp;
    }

    public void setDateExp(String dateExp) {
        this.dateExp = dateExp;
    }

    @Override
    public String toString() {
        return super.toString() + (kosher ? " Kosher " : " No kosher ") + "Expiry date: " + dateExp;
    }
}
