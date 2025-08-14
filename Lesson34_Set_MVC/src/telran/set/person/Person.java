package telran.set.person;

import java.util.Objects;

public class Person implements Comparable<Person> {
    private String LasName;
    private String firstName;
    private int id;

    public Person(int id, String firstName, String lasName)  {
        LasName = lasName;
        this.firstName = firstName;
        this.id = id;
    }

    public String getLasName() {
        return LasName;
    }

    public void setLasName(String lasName) {
        LasName = lasName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "LasName='" + LasName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public int compareTo(Person o) {
        return Integer.compare(id, o.id);
    }
}
