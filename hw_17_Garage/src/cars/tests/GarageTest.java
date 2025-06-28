package cars.tests;

import cars.dao.Garage;
import cars.dao.GarageImpl;
import cars.model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GarageTest {

    private Garage garage;
    private Car[] cars;

    @BeforeEach
    void setUp() {
        garage = new GarageImpl(11);
        cars = new Car[10];
        cars[0] = new Car("REG1", "Corolla", "Toyota", 1.6, "Red");
        cars[1] = new Car("REG2", "Civic", "Honda", 1.8, "Blue");
        cars[2] = new Car("REG3", "Corolla", "Toyota", 1.6, "Red");      // same model + brand + color
        cars[3] = new Car("REG4", "Model 3", "Tesla", 2.0, "White");
        cars[4] = new Car("REG5", "Corolla", "Toyota", 1.4, "Red");      // same model + brand + color
        cars[5] = new Car("REG6", "Civic", "Honda", 1.5, "Green");       // same model + brand
        cars[6] = new Car("REG7", "CX-5", "Mazda", 2.2, "Red");          // same color
        cars[7] = new Car("REG8", "Elantra", "Hyundai", 1.6, "Blue");    // same color
        cars[8] = new Car("REG9", "Rio", "Kia", 1.4, "Blue");            // same color
        cars[9] = new Car("REG10", "208", "Peugeot", 1.2, "Black");
        for (int i = 0; i < cars.length; i++) {
            garage.addCar(cars[i]);
        }
    }

    @Test
    void addCarTest() {
        Car car = null;
        assertFalse(garage.addCar(car));
        assertEquals(cars.length, garage.size());
        car = new Car("", "208", "Peugeot", 1.2, "Black");
        assertFalse(garage.addCar(car));
        assertEquals(cars.length, garage.size());
        car = new Car("REG1", "", "", 0, "");
        assertFalse(garage.addCar(car));
        assertEquals(cars.length, garage.size());
        car = new Car("REG11", "208", "Peugeot", 1.2, "Black");
        assertTrue(garage.addCar(car));
        assertEquals(cars.length+1, garage.size());
        car = new Car("REG12", "208", "Peugeot", 1.2, "Black");
        assertFalse(garage.addCar(car));
        assertEquals(cars.length+1, garage.size());
    }

    @Test
    void removeCarTest() {
        assertNull(garage.removeCar("REG13"));
        assertEquals(cars[6], garage.removeCar("REG7"));
        assertEquals(9,garage.size());
        assertNull(garage.findCarByNumber("REG7"));
    }

    @Test
    void findCarByNumberTest() {
        assertEquals(cars[2],garage.findCarByNumber("REG3"));
        assertNull(garage.findCarByNumber("REG12"));
    }

    @Test
    void findCarsByModelTest() {

        Car[] carsByModel = {cars[1],cars[5]};
        assertArrayEquals(carsByModel, garage.findCarsByModel("Civic"));
        assertArrayEquals(new Car[0], garage.findCarsByModel("Volga"));
    }

    @Test
    void findCarsByCompanyTest() {

        Car[] carsByModel = {cars[0],cars[2],cars[4]};
        assertArrayEquals(carsByModel, garage.findCarsByCompany("Toyota"));
        assertArrayEquals(new Car[0], garage.findCarsByCompany("Volga"));
    }

    @Test
    void findCarsByEngineTest() {

        Car[] carsByEngine = {cars[0], cars[1], cars[2], cars[7]};
        assertArrayEquals(carsByEngine, garage.findCarsByEngine(1.6,2));
        assertArrayEquals(new Car[0], garage.findCarsByEngine(3,4));
    }

    @Test
    void findCarsByColorTest() {

        Car[] carsByColor = {cars[1], cars[7], cars[8]};
        assertArrayEquals(carsByColor, garage.findCarsByColor("Blue"));
        assertArrayEquals(new Car[0], garage.findCarsByColor("Purple"));
    }

    @Test
    void sizeTest() {
        assertEquals(cars.length,garage.size());
    }
}