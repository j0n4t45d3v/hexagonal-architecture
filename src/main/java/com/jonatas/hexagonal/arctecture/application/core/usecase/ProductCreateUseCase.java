package com.jonatas.hexagonal.arctecture.application.core.usecase;

import com.jonatas.hexagonal.arctecture.application.core.domain.Product;
import com.jonatas.hexagonal.arctecture.application.ports.in.CreateProductPort;
import com.jonatas.hexagonal.arctecture.application.ports.out.SaveProductRepositoryPort;

public class ProductCreateUseCase implements CreateProductPort {

    private final SaveProductRepositoryPort productRepository;

    public ProductCreateUseCase(SaveProductRepositoryPort productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(String name, String description, Double price, Long quantity) {
        Product product = new Product(name, description, price, quantity);
        return this.productRepository.save(product);
    }
}
