package ru.geekgrains.SpringData.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekgrains.SpringData.repository.ProductRepository;
import ru.geekgrains.SpringData.entity.Product;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productRepository.findById(id).get();
    }

    @PostMapping
    public Product save(@RequestBody Product product){
        product.setId(null);
        return productRepository.save(product);
    }

    @GetMapping("/delete/{id}")
    public List<Product> deleteProductById(@PathVariable Long id){
        productRepository.deleteById(id);
        return productRepository.findAll();
    }

    @GetMapping("/search_min")
    public List<Product> searchByMin(@RequestParam(name = "min") int price){
        return productRepository.findAllByPriceGreaterThanEqual(price);
    }

    @GetMapping("/search_max")
    public List<Product> searchByMax(@RequestParam(name = "max") int price){
        return productRepository.findAllByPriceLessThanEqual(price);
    }

    @GetMapping("/search_between")
    public List<Product> searchByBetween(@RequestParam(name = "min") int min,
                                         @RequestParam(name = "max") int max){
        return productRepository.findAllByPriceBetween(min, max);
    }
}
