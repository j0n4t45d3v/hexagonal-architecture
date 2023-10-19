package com.jonatas.hexagonal.arctecture.application.ports.out;

import com.jonatas.hexagonal.arctecture.application.core.domain.Product;

public interface SaveProductRepositoryPort {
    Product save(Product product);
}
