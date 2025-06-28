package product.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import product.dao.ProductStorage;
import product.dao.ProductStorageImpl;
import product.model.Product;
import static org.junit.jupiter.api.Assertions.*;

public class ProductStorageTest {
    private ProductStorage storage;
    Product[] products;

    @BeforeEach
    void setUp() {
        storage = new ProductStorageImpl(7);
        products = new Product[6];
        products[0] = new Product("P001", "Apple", "Fruit", 1.5, 100);
        products[1] = new Product("P002", "Apple", "Fruit", 1.6, 80);
        products[2] = new Product("P003", "Milk", "Dairy", 2.0, 50);
        products[3] = new Product("P004", "Milk", "Dairy", 2.2, 60);
        products[4] = new Product("P005", "Bread", "Bakery", 1.0, 40);
        products[5] = new Product("P006", "Bread", "Bakery", 1.1, 30);
        for (int i = 0; i < products.length; i++) {
            storage.addProduct(products[i]);
        }
    }

    @Test
    void addProductTest() {
        assertFalse(storage.addProduct(null));
        Product product = new Product("P001", "Apple", "Fruit", 1.5, 100);
        assertFalse(storage.addProduct(product));
        product = new Product("P007", "Apple", "Fruit", 1.5, 100);
        assertTrue(storage.addProduct(product));
        product = new Product("P008", "Apple", "Fruit", 1.5, 100);
        assertFalse(storage.addProduct(product));
    }

    @Test
    void removeProductTest() {
        assertNull(storage.removeProduct("P009"));
        assertEquals(products[0],storage.removeProduct("P001"));
        assertNull(storage.removeProduct("P001"));
    }

    @Test
    void findProductByIdTest() {
        assertEquals(products[0],storage.findProductById("P001"));
        assertNull(storage.findProductById("P009"));
    }

    @Test
    void findProductsByNameTest() {
        Product[] excepted = {products[2], products[3]};
        assertArrayEquals(excepted, storage.findProductsByName("Milk"));
    }

    @Test
    void findProductsByCategoryTest() {
        Product[] prod = {products[0], products[1]};
        assertArrayEquals(prod, storage.findProductsByCategory("Fruit"));
    }

    @Test
    void findProductsByPriceTest() {
        Product[] prod = {products[0], products[1], products[4], products[5]};
        assertArrayEquals(prod, storage.findProductsByPrice(1,1.9));
    }

    @Test
    void findProductsByQuantityTest() {
        Product[] prod = {products[2], products[4], products[5]};
        assertArrayEquals(prod, storage.findProductsByQuantity(30,50));
    }
}
