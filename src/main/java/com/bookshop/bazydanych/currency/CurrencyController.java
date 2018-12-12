package com.bookshop.bazydanych.currency;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/currencies")
public class CurrencyController {

    private CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/all")
    public List<Currency> getAll(){
        return currencyService.getCurrencies();
    }

    @PostMapping("/add")
    public void addCurrency(@RequestBody Currency currency){
        currencyService.addCurrency(currency);
    }

    @GetMapping("/{id}")
    public Currency getCurrency(@PathVariable Long id){
        return currencyService.getCurrency(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCurrencyById(@PathVariable Long id){
        currencyService.deleteCurrencyById(id);
    }
}
