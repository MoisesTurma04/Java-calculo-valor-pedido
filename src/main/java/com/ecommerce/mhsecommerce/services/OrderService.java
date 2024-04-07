package com.ecommerce.mhsecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.mhsecommerce.entities.Order;

@Service
public class OrderService {

	@Autowired
	private ShippingService shippingService;

	public double total(Order order) {
		double basic = order.getBasic();
		double discount = order.getDiscount();
		double shipping = shippingService.shipment(order);
		return (basic - (basic * (discount / 100))) + shipping;
	}

}
