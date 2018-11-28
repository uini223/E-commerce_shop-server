package com.bookshop.bazydanych.shop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shops")
public class ShopController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ShopController.class);

	private ShopRepository shopRepository;

	public ShopController(ShopRepository shopRepository) {
		this.shopRepository = shopRepository;
	}

	@PostMapping("/add")
	public void createShop(@RequestBody Shop shop) {
		LOGGER.info("Creating new shop instance");
		shopRepository.save(shop);
	}
}
