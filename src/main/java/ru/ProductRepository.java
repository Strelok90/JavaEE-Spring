package ru;


import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {

    List<Product> productList;


    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public ProductRepository(List<Product> productList) {
        Collections.unmodifiableList(productList);
    }

    @PostConstruct
    public void init() {
        productList = new ArrayList<>();
        productList.add(new Product(1, "Bread", 76));
        productList.add(new Product(2, "Milk", 95));
        productList.add(new Product(3, "Cheese", 260));
        productList.add(new Product(4, "Eggs", 90));
        productList.add(new Product(5, "Apple", 99));
    }


    public void showAllProducts() {
        for (Product p : productList) {
            System.out.println(p);
        }
    }

    public void showProductNameById(Long id) {
        Product tmp = null;
        for (Product p : productList) {
            if (p.getId() == id) {
                tmp = p;
            }
        }
        if (tmp != null) {
            System.out.println(tmp);
        } else {
            System.out.println("Продукт с таким ID не найден в базе..");
        }
    }

    public Product getProductById(Long id) {
        Product tmp = null;
        for (Product p : productList) {
            if (p.getId() == id) {
                tmp = p;
            }
        }
        return tmp;
    }
}