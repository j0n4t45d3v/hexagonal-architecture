package com.jonatas.hexagonal.arctecture.application.ports.in;

import com.jonatas.hexagonal.arctecture.application.core.domain.Product;

public interface CreateProductPort {
    Product createProduct(String name, String description, Double price, Long quantity);
}
