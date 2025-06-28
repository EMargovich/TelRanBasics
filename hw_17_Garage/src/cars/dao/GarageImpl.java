package cars.dao;

import cars.model.Car;

import java.util.Objects;
import java.util.function.Predicate;

public class GarageImpl implements Garage {
    private int size;
    private Car[] cars;

    public GarageImpl(int capacity) {
        this.cars = new Car[capacity];
    }

    @Override
    public boolean addCar(Car car) {
        if (car != null
                && car.getRegNumber() != ""
                && findCarByNumber(car.getRegNumber())  == null
                && size < cars.length) {
            cars[size++] = car;
            return true;
        }
        return false;
    }

    @Override
    public Car removeCar(String regNumber) {
        for (int i = 0; i < size; i++) {
            if(cars[i].getRegNumber() == regNumber) {
                Car deleted = cars[i];
                cars[i] = cars[--size];
                cars[size] = null;
                return deleted;
            }
        }
        return null;
    }

    @Override
    public Car findCarByNumber(String regNumber) {
        for (int i = 0; i < size; i++) {
            if(Objects.equals(cars[i].getRegNumber(), regNumber)) { //Этот вариант предложил Intelliji Нужно разобраться
                return cars[i];
            }
        }
        return null;
    }

//    @Override
//    public Car[] findCarsByModel(String model) {
//        return findCarsByPredicate((car) -> model.equals(car.getModel()));
//    }
//
//    @Override
//    public Car[] findCarsByCompany(String company) {
//        return findCarsByPredicate((car) -> company.equals(car.getCompany()));
//    }
//
//    @Override
//    public Car[] findCarsByEngine(double min, double max) {
//        return findCarsByPredicate((car) -> car.getEngine() >= min && car.getEngine() < max);
//    }
//
//    @Override
//    public Car[] findCarsByColor(String color) {
//        return findCarsByPredicate((car) -> color.equals(car.getColor()));
//    }

    @Override
    public int size() {
        return size;
    }

    public Car[] findCarsByPredicate(Predicate<Car> predicate) {
        int count=0;
        for (int i = 0; i < size; i++) {
            if(predicate.test(cars[i])) {
                count++;
            }
        }
        Car[] res = new Car[count];
        for (int i = 0, k = 0; k < res.length; i++) {
            if(predicate.test(cars[i])) {
                res[k++] = cars[i];
            }
        }
        return res;
    }
}
