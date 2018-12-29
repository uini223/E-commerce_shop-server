package com.bookshop.bazydanych.product;

import com.bookshop.bazydanych.basket.BasketService;
import com.bookshop.bazydanych.basket.productReservation.ProductReservationRepository;
import com.bookshop.bazydanych.category.Category;
import com.bookshop.bazydanych.category.CategoryService;
import com.bookshop.bazydanych.currency.Currency;
import com.bookshop.bazydanych.currency.CurrencyService;
import com.bookshop.bazydanych.order.OrderRepository;
import com.bookshop.bazydanych.order.OrderService;
import com.bookshop.bazydanych.platform.Platform;
import com.bookshop.bazydanych.platform.PlatformService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private CurrencyService currencyService;
    private PlatformService platformService;
    private CategoryService categoryService;
    private BasketService basketService;
    private ProductReservationRepository productReservationRepository;
    private OrderService orderService;
    private OrderRepository orderRepository;

    public ProductService(ProductRepository productRepository, CurrencyService currencyService, PlatformService platformService, CategoryService categoryService, BasketService basketService, ProductReservationRepository productReservationRepository, OrderService orderService, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.currencyService = currencyService;
        this.platformService = platformService;
        this.categoryService = categoryService;
        this.basketService = basketService;
        this.productReservationRepository = productReservationRepository;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
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

    public Product getByName(String name){
        return productRepository.getByName(name);
    }

    public void deactivateProduct(Long id){
        Product productToUpdate = productRepository.getOne(id);
        productToUpdate.setStatus(Character.toString('0'));
        productReservationRepository.findAll().forEach(a ->{
            if(a.getProductId() == id){
                productReservationRepository.deleteById(a.getProductReservationId());
            }
        });
        productRepository.save(productToUpdate);
    }

    public List<Product> getProductsByIds(Collection<Long> ids) {
        return productRepository.getAllByIdIn(ids);
    }

    public List<Product> getActive(){
        return productRepository.findAll().stream().filter(
                p -> p.getStatus().equals(Character.toString('1'))
        ).collect(Collectors.toList());
    }

    public Product getbyId(Long id){
        return productRepository.getById(id);
    }

    public void updateProduct(Product productOld){
        Product product = new Product(
                productOld.getName(),
                productOld.getUnit(),
                productOld.getProducent(),
                productOld.getStock(),
                productOld.getPrice(),
                productOld.getStatus(),
                productOld.getDescription(),
                productOld.getCurrency(),
                productOld.getCategory(),
                productOld.getPlatform());


        ArrayList<Long> orders = new ArrayList<>();
        orderService.getAllOrders().forEach(a -> {
            a.getProductIds().forEach(b ->{
                if(b == product.getId()){
                    if(!orders.contains(a)){
                        orders.add(a.getId());
                    }
                }
            });
        });

        if(orders.isEmpty()){
            deactivateProduct(productOld.getId());
        } else {
            productReservationRepository.getAllByProductReservationId_ProductId(product.getId()).forEach( a->{
                a.setProductId(product.getId());
            });
        }

        productRepository.save(product);
    }
}
