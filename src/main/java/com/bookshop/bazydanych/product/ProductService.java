package com.bookshop.bazydanych.product;

import com.bookshop.bazydanych.category.Category;
import com.bookshop.bazydanych.category.CategoryService;
import com.bookshop.bazydanych.currency.Currency;
import com.bookshop.bazydanych.currency.CurrencyService;
import com.bookshop.bazydanych.platform.Platform;
import com.bookshop.bazydanych.platform.PlatformService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private CurrencyService currencyService;
    private PlatformService platformService;
    private CategoryService categoryService;

    public ProductService(ProductRepository productRepository, CurrencyService currencyService, PlatformService platformService, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.currencyService = currencyService;
        this.platformService = platformService;
        this.categoryService = categoryService;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    public void addProduct(ProductDTO product){
        Currency newCurrency = currencyService.getCurrency(product.getCurrency_id());
        Platform newPlatform = platformService.getPlatform(product.getPlatform_id());
        Category newCategory = categoryService.getCategory(product.getCategory_id());

        Product newProduct = new Product(product.getName(),product.getUnit(),product.getProducent(),product.getStock(),product.getPrice(),product.getStatus(),product.getDescription(),newCurrency,newCategory,newPlatform);
        productRepository.save(newProduct);
    }

    public void deactivateProduct(Long id){
        Product productToUpdate = productRepository.getOne(id);
        productToUpdate.setStatus(Character.toString('0'));
        productRepository.save(productToUpdate);
    }

    public List<Product> getActive(){
        return productRepository.findAll().stream().filter(
                p -> p.getStatus().equals(Character.toString('1'))
        ).collect(Collectors.toList());
    }
}
