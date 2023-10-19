package com.jonatas.hexagonal.arctecture.adapters.inbount.mapper;

import com.jonatas.hexagonal.arctecture.adapters.inbount.entity.ProductEntity;
import com.jonatas.hexagonal.arctecture.application.core.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductEntityToProduct {

    public Product map(ProductEntity product) {
        return new Product(
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getQuantity()
        );
    }
}
