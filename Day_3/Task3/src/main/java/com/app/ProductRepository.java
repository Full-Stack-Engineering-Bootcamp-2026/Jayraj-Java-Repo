package com.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

	private final List<Product> products = List.of(
            new Product(1, "Laptop", 60000, "Electronics"),
            new Product(2, "Phone", 30000, "Electronics"),
            new Product(3, "Shoes", 2000, "Fashion"),
            new Product(4, "Watch", 5000, "Accessories"),
            new Product(5, "Headphones", 2500, "Electronics")
    );

    public List<Product> findAll() {
        return products;
    }

    public Optional<Product> findById(int id) {
        return products.stream()
                .filter(p -> p.getId() == id)
                .findFirst();
    }

}
