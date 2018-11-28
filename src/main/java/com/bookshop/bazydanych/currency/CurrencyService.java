package com.bookshop.bazydanych.currency;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyService {

    private CurrencyRepository currencyRepository;

    public CurrencyService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
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

}
