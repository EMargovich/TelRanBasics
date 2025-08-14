package citizens.entities;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Person implements Comparable<Person> {
    private int id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private LocalDate now = LocalDate.now();


    public Person(int id, String firstName, String lastName, LocalDate birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        if (birthDate == null && birthDate.isAfter(now))
            throw new IllegalArgumentException();
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
       // return Period.between(birthDate, LocalDate.now()).getYears();
        if (birthDate == null) return -1;
        return (int) ChronoUnit.YEARS.between(birthDate, LocalDate.now());
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public int compareTo(Person o) {
        return Integer.compare(id, o.getId());
    }


    @Override
    public String toString() {
        return "Person: " +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                '.';
    }
}
