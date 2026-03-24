package com.app;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

	
	private ProductRepository productRepository;
	private PricingService pricingService;

	public ProductService(ProductRepository productRepository , PricingService pricingService) {
		super();
		this.productRepository = productRepository;
		this.pricingService = pricingService;
	}
	
	public List<Product> findAll() {
        List<Product> products = productRepository.findAll();
        
        return products.stream()
        		.map(p -> new Product(
        				p.getId(),
        				p.getName(),
        				pricingService.applyDiscount(p.getPrice()),
        				p.getCategory()
        			))
        			.toList();
    }

    public Optional<Product> findById(int id) {
        return productRepository.findById(id);
    }
	
	
}
