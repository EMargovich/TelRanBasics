package telran.book.model;

import java.time.Year;

public class Publication {
    private String title;
    private int yearOfPublication;
    private String author;

    public Publication(String title) {
        if (title == "") {
            System.out.println("Title is required");
        } else {
            this.title = title;
        }
    }

    public Publication(String title, int yearOfPublication, String author) {
        this(title);
        setYearOfPublication(yearOfPublication);
        setAuthor(author);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == "") {
            System.out.println("Title is required");
        } else {
            this.title = title;
        }
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        if (yearOfPublication > 1900 && yearOfPublication < Year.now().getValue() + 1) {
            this.yearOfPublication = yearOfPublication;
        } else {
            System.out.println("Invalid year entered");
        }

    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == "" ? "unknown" : author;
    }

    public void display() {
        System.out.println("Title: " + title + "\nAuthor: " + author + "\nYear: " + yearOfPublication);
    }


}
