package com.ecommerce.mhsecommerce.services;

import org.springframework.stereotype.Service;

import com.ecommerce.mhsecommerce.entities.Order;

@Service
public class ShippingService {

	public double shipment(Order order) {
		double basic = order.getBasic();
		double shippingCost = 0.00;

		if (basic < 100) {
			shippingCost = 20.00;
		} else if (basic >= 100 && basic <= 200) {
			shippingCost = 12.00;
		} else {
			shippingCost = 0.00;
		}

		return shippingCost;
	}

}
