package com.app;

import org.springframework.stereotype.Service;

@Service
public class PricingService {
	public double applyDiscount(double price) {
        return price * 0.9; 
    }
}
