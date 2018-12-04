package com.bookshop.bazydanych.product;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public List<Product> getAll() {
        return productService.getAllProducts();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }

    @PostMapping("/add")
    public void addProduct(@RequestBody ProductDTO product){
        productService.addProduct(product);
    }

    @DeleteMapping("/deactivate/{id}")
    public void deactivateProduct(@PathVariable Long id){
        productService.deactivateProduct(id);
    }

    @GetMapping("/active")
    public List<Product> getActive(){
        return productService.getActive();
    }

    @GetMapping("/get/{id}")
    public Product getProduct(@PathVariable long id) {
        return productService.getProduct(id);
    }
}
