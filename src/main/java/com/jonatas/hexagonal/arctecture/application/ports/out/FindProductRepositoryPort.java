package com.jonatas.hexagonal.arctecture.application.ports.out;

import com.jonatas.hexagonal.arctecture.application.core.domain.Product;

import java.util.List;
import java.util.Optional;

public interface FindProductRepositoryPort {
    List<Product> findAll();
    Optional<Product> findByName(String name);
}
