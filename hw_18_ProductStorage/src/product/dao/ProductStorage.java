package product.dao;

import product.model.Product;

import java.util.function.Predicate;

public interface ProductStorage {

    public boolean addProduct(Product product);
    public Product removeProduct(String id);
    public Product findProductById(String is);
    public default Product[] findProductsByName (String name) {
        return findProductByPredicate(product -> product.getName().equals(name));
    };
    public default Product[] findProductsByCategory (String category) {
        return findProductByPredicate(product -> product.getCategory().equals(category));
    };
    public default Product[] findProductsByPrice (double min, double max) {
        return findProductByPredicate(product -> product.getPrice() >= min && product.getPrice() <= max);
    };
    public default Product[] findProductsByQuantity (int min, int max) {
        return findProductByPredicate(product -> product.getQuantity() >= min && product.getQuantity() <= max);
    };
    public Product[] findProductByPredicate(Predicate<Product> predicate);

}
