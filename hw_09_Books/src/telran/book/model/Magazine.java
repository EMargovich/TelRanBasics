package telran.book.model;


public class Magazine extends Publication {

    String publicationMonth;

    public Magazine(String title, int yearOfPublication, String publicationMonth) {
        super(title, yearOfPublication, "-");
        this.publicationMonth = publicationMonth;
    }

    public void display() {
        super.display();
        System.out.println("Month: " + publicationMonth + "\n");
    }

}
