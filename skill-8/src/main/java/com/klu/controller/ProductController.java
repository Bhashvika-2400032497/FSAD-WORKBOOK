package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.model.Product;
import com.klu.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product p) {
        return service.addProduct(p);
    }

    @GetMapping("/category/{category}")
    public List<Product> getByCategory(@PathVariable String category) {
        return service.getByCategory(category);
    }

    @GetMapping("/filter")
    public List<Product> getByPriceRange(@RequestParam double min, @RequestParam double max) {
        return service.getByPriceRange(min, max);
    }

    @GetMapping("/sorted")
    public List<Product> getSortedProducts() {
        return service.getSortedProducts();
    }

    @GetMapping("/expensive/{price}")
    public List<Product> getExpensiveProducts(@PathVariable double price) {
        return service.getExpensiveProducts(price);
    }
}