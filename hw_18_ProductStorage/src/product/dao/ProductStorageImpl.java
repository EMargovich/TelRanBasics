package product.dao;

import product.model.Product;

import java.util.function.Predicate;

public class ProductStorageImpl implements ProductStorage {
    Product[] products;
    int size;

    public ProductStorageImpl(int capacity) {
        products = new Product[capacity];
    }

    @Override
    public boolean addProduct(Product product) {
        if( product != null
                && findProductById(product.getId()) == null
                && size < products.length
        ) {
            products[size++] = product;
            return true;
        }
        return false;
    }

    @Override
    public Product removeProduct(String id) {
        for (int i = 0; i < size; i++) {
            if(products[i].getId().equals(id)) {
                Product victim = products[i];
                products[i] = products[--size];
                products[size] = null;
                return victim;
            }
        }
        return null;
    }

    @Override
    public Product findProductById(String id) {
        for (int i = 0; i < size; i++) {
            if(products[i].getId().equals(id)) {
                return products[i];
            }
        }
        return null;
    }

    public Product[] findProductByPredicate(Predicate<Product> predicate) {
        int count=0;
        for (int i = 0; i < size; i++) {
            if (predicate.test(products[i])) {
                count++;
            }
        }

        Product[] res = new Product[count];
        for (int i = 0, j = 0; j < res.length; i++) {
            if(predicate.test(products[i])) {
                res[j++] = products[i];
            }
        }
        return res;
    }
}
