package com.bookshop.bazydanych.basket;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/basket")
public class BasketController {

	private final BasketService basketService;

	public BasketController(BasketService basketService) {
		this.basketService = basketService;
	}

	@GetMapping("/get/customer/{customerId}")
	public Basket getBasketForCustomer(@PathVariable long customerId) {
		return basketService.getBasketForCustomerId(customerId);
	}

	@PostMapping("/add/customer/{customerId}/product/{productId}")
	public void addProductToBasket(@PathVariable long customerId, @PathVariable long productId,
								   @RequestBody Quantity quantity) {
		basketService.addProductToBasket(customerId, productId, quantity.getQuantity());
	}

	@PutMapping("/edit/customer/{customerId}/product/{productId}")
	public void editProductQuantityInBasket(@PathVariable long customerId, @PathVariable long productId,
											@RequestBody Quantity quantity) {
		basketService.updateProductQuantityInBasket(customerId, productId, quantity.getQuantity());
	}

	@DeleteMapping("/delete/customer/{customerId}/product/{productId}")
	public void deleteProductFromBasket(@PathVariable long customerId, @PathVariable long productId) {
		basketService.removeProductFromBasket(customerId, productId);
	}

	@DeleteMapping("delete/customer/{customerId}")
	public void deleteAllProductsFromBasket(@PathVariable long customerId) {
		basketService.clearCustomerBasket(customerId);
	}

	public void makeOrderFromBasket() {

	}
}
