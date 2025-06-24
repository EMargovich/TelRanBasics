package cars.dao;

import cars.model.Car;

import java.util.Objects;
import java.util.function.Predicate;

public class GarageImpl implements Garage {
    private int size;
    private Car[] cars;

    public GarageImpl(int capacity) {
        cars = new Car[capacity];
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
                cars[i] = cars[size-1];
                cars[--size] = null;
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

    @Override
    public Car[] findCarsByModel(String model) {
        Predicate<Car> predicate = new Predicate<Car>() {
            @Override
            public boolean test(Car car) {
                return model.equals(car.getModel());
            }
        };
        return findCarsByPredicate(predicate);
    }

    @Override
    public Car[] findCarsByCompany(String company) {
        Predicate<Car> predicate = new Predicate<Car>() {
            @Override
            public boolean test(Car car) {
                return company.equals(car.getCompany());
            }
        };
        return findCarsByPredicate(predicate);
    }

    @Override
    public Car[] findCarsByEngine(double min, double max) {
        Predicate<Car> predicate = new Predicate<Car>() {
            @Override
            public boolean test(Car car) {
                return car.getEngine() >= min && car.getEngine() < max;
            }
        };
        return findCarsByPredicate(predicate);
    }

    @Override
    public Car[] findCarsByColor(String color) {
        Predicate<Car> predicate = new Predicate<Car>() {
            @Override
            public boolean test(Car car) {
                return color.equals(car.getColor());
            }
        };
        return findCarsByPredicate(predicate);
    //    return findCarsByPredicate(car -> color.equals(car.getColor()));
    }

    @Override
    public int size() {
        return size;
    }

    private Car[] findCarsByPredicate(Predicate<Car> predicate) {
        int count=0;
        for (int i = 0; i < size; i++) {
            if(predicate.test(cars[i])) {
                count++;
            }
        }
        Car[] res = new Car[count];
        for (int i = 0, k = 0; i < size; i++) {
            if(predicate.test(cars[i])) {
                res[k++] = cars[i];
            }
        }
        return res;
    }
}
