package codegym.service;

import codegym.entity.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {
    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Fan", 500.0, "Good", "Samsung"));
        products.put(2, new Product(2, "Phone", 5000.0, "Good", "Nokia"));
        products.put(3, new Product(3, "AC", 10000.0, "Good", "Samsung"));
        products.put(4, new Product(4, "TV", 25000.0, "Good", "Samsung"));
        products.put(5, new Product(5, "Fan", 500.0, "Good", "Panasonic"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
