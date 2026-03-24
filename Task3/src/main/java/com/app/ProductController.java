package com.app;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	private ProductService productService;

	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	@GetMapping("/products")
	public List<Product> getAllproducts(){
		return productService.findAll();
	}
	
	@GetMapping("products/{id}")
    public Product getProductById(@PathVariable int id) {
        return productService.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }
}
