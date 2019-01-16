package com.bookshop.bazydanych.basket;

import com.bookshop.bazydanych.basket.productReservation.ProductReservation;
import com.bookshop.bazydanych.basket.productReservation.ProductReservationId;
import com.bookshop.bazydanych.basket.productReservation.ProductReservationRepository;
import com.bookshop.bazydanych.order.Order;
import com.bookshop.bazydanych.order.OrderService;
import com.bookshop.bazydanych.order.PaymentType;
import com.bookshop.bazydanych.order.TransportType;
import com.bookshop.bazydanych.product.ProductSimpleDTO;
import com.bookshop.bazydanych.shared.ProcedureRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BasketService {

	private final ProductReservationRepository productReservationRepository;
	private final OrderService orderService;
	private final ProcedureRepository procedureRepository;

	public BasketService(ProductReservationRepository productReservationRepository, OrderService orderService, ProcedureRepository procedureRepository) {
		this.productReservationRepository = productReservationRepository;
		this.orderService = orderService;
		this.procedureRepository = procedureRepository;
	}

	@Transactional
	public Basket getBasketForCustomerId(long customerId) {
		return new Basket(productReservationRepository.getAllByProductReservationId_CustomerId(customerId).stream()
							  .map(pr -> new ProductSimpleDTO(pr.getProductId(), pr.getProduct().getName(),
								  pr.getProduct().getUnit(), pr.getProduct().getStock(), pr.getProduct().getPrice(),
								  pr.getQuantity()))
							  .collect(Collectors.toList()));
	}

	@Transactional
	public void addProductToBasket(long customerId, long productId, long quantity) {
		if(productReservationRepository
			   .getByProductReservationId(new ProductReservationId(customerId, productId)) != null) {
			throw new RuntimeException("Product already in basket! Method for update should be used");
		}
		productReservationRepository.save(new ProductReservation(customerId, productId, quantity));
	}

	@Transactional
	public void removeProductFromBasket(long customerId, long productId) {
		productReservationRepository.deleteById(new ProductReservationId(customerId, productId));
	}

	@Transactional
	public void updateProductQuantityInBasket(long customerId, long productId, long quantity) {
		ProductReservation productReservation = productReservationRepository
													.getOne(new ProductReservationId(customerId, productId));
		productReservation.updateQuantity(quantity);
		productReservationRepository.save(productReservation);
	}

	@Transactional
	public void clearCustomerBasket(long customerId) {
		productReservationRepository.deleteAllByProductReservationId_CustomerId(customerId);
	}

	@Transactional
	public void makeOrderFromBasket(long customerId, PaymentType paymentType, TransportType transportType) {
		List<ProductSimpleDTO> products = getBasketForCustomerId(customerId).getProducts();
		if(products.isEmpty()) {
			throw new RuntimeException("Order cannot be empty");
		}
		Order order = orderService.createOrder(customerId, paymentType, transportType);
		procedureRepository.moveProductsFromBasketToOrder(customerId, order.getId());
		for (long productId :
			order.getProductIds()) {
			productReservationRepository.getAllByProductReservationId_ProductId(productId).forEach(e -> {

			});

		}
	}

	public BigDecimal calculatePriceWithTax(long customerId) {
		return  procedureRepository.getTotalPrice(customerId);
	}
}
