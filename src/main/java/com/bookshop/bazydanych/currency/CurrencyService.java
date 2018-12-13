package com.bookshop.bazydanych.currency;

import com.bookshop.bazydanych.product.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyService {

    private CurrencyRepository currencyRepository;
    private ProductRepository productRepository;

    public CurrencyService(CurrencyRepository currencyRepository, ProductRepository productRepository) {
        this.currencyRepository = currencyRepository;
        this.productRepository = productRepository;
    }

    public List<Currency> getCurrencies(){
        return currencyRepository.findAll();
    }

    public void addCurrency(Currency currency){
        currencyRepository.save(currency);
    }

    public Currency getCurrency(Long id){
        return currencyRepository.findById(id).get();
    }

    public void deleteCurrencyById(Long id){
        if(productRepository.getAllByCurrencyId(id).isEmpty()){
            currencyRepository.deleteById(id);
        } else {
            throw new RuntimeException("Category in use!");
        }
    }

}
