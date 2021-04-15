package com.example.repositories;

import com.example.model.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class ProductRepository {
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    @PostConstruct
    public void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product (1L, "Яблоко", 50),
                new Product (2L, "Апельсин", 60),
                new Product (3L, "Лимон", 40),
                new Product (4L, "Авокадо", 100),
                new Product (5L, "Чеснок", 100),
                new Product (6L, "Банан", 30)
        ));
    }

    public Optional<Product> getProductById (Long id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }

    public void save(Product product) {
        products.add(product);
    }
}
