package com.jonatas.hexagonal.arctecture.application.ports.in;

import com.jonatas.hexagonal.arctecture.application.core.domain.Product;

import java.util.List;

public interface FindProductPort {
    List<Product> findAll();

    Product findByName(String name);
}
