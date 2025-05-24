package telran.book;

import telran.book.model.Publication;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Newspaper extends Publication {
    Date dateOfPublication = new Date();

    public Newspaper(String title, int yearOfPublication, int month, int day) {
        super(title, yearOfPublication, "-");
        this.dateOfPublication.setMonth(month);
        this.dateOfPublication.setDate(day);
        this.dateOfPublication.setYear(yearOfPublication-1900);
    }

    @Override
    public void display() {
        super.display();
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd");
        System.out.println("Date: " + sdf.format(dateOfPublication) + "\n");

    }
}
