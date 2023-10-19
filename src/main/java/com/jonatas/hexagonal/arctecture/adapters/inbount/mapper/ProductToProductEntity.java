package com.jonatas.hexagonal.arctecture.adapters.inbount.mapper;

import com.jonatas.hexagonal.arctecture.adapters.inbount.entity.ProductEntity;
import com.jonatas.hexagonal.arctecture.application.core.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductToProductEntity {

    public ProductEntity map(Product product){
        return ProductEntity.builder()
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build();
    }
}
