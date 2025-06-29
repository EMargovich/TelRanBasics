package telran.money.model;

import telran.money.tests.MoneyTest;

import java.util.Objects;

public class Money implements Comparable<Money> {

    double width;
    double length;
    int value;

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public int getValue() {
        return value;
    }

    public Money(double width, double length, int value) {
        this.width = width;
        this.length = length;
        this.value = value;
    }

    @Override
    public String toString() {
        return "MoneyTest{" +
                "width=" + width +
                ", length=" + length +
                ", value=" + value +
                '}' +
                " Square= " +
                getSquare() +
                "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Double.compare(width, money.width) == 0 && Double.compare(length, money.length) == 0 && value == money.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, length, value);
    }

    @Override
    public int compareTo(Money o) {
        return value - o.value;
    }

    public double getSquare() {
        return length*width;
    }
}
