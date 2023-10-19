package com.jonatas.hexagonal.arctecture.application.ports.out;

import com.jonatas.hexagonal.arctecture.application.core.domain.Product;

public interface DeleteProductRepositoryPort {
    void delete(Product product);
}
