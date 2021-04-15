package com.example.controllers;

import com.example.model.Product;
import com.example.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    // http://localhost:8189/app/products/all
    @GetMapping("/all")
    public String showAllProductsPage(Model model) {
        List<Product> products = productService.getProducts();
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/{id}")
    public String showProductInfo(@PathVariable(name = "id") Long id, Model model) {
        Optional<Product> product = productService.getProductById(id);
        if (product.isPresent()) {
            model.addAttribute("product", product.get());
        }
        return "product_info";
    }

    @GetMapping("/create")
    public String showCreator() {
        return "create_product_form";
    }

    @PostMapping("/create")
    public String createProduct(@RequestParam Long id, @RequestParam String title, @RequestParam int cost) {
        Product product = new Product(id, title, cost);
        productService.save(product);
        return "redirect:/products/all";
    }
}
