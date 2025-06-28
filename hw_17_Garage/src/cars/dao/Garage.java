package cars.dao;

import cars.model.Car;

import java.util.function.Predicate;
import java.util.regex.Pattern;

public interface Garage {

    boolean addCar(Car car);

    Car removeCar(String regNumber);

    Car findCarByNumber(String regNumber);

    default Car[] findCarsByModel(String model) {
        return findCarsByPredicate((car) -> model.equals(car.getModel()));
    }

    default Car[] findCarsByCompany(String company) {
        return findCarsByPredicate((car) -> company.equals(car.getCompany()));
    }

    default Car[] findCarsByEngine(double min, double max) {
        return findCarsByPredicate((car) -> car.getEngine() >= min && car.getEngine() < max);
    }

    default Car[] findCarsByColor(String color) {
        return findCarsByPredicate((car) -> color.equals(car.getColor()));
    }

    int size();

    Car[] findCarsByPredicate(Predicate<Car> predicate);
}
