package com.jonatas.hexagonal.arctecture.application.core.usecase;

import com.jonatas.hexagonal.arctecture.application.core.domain.Product;
import com.jonatas.hexagonal.arctecture.application.ports.in.FindProductPort;
import com.jonatas.hexagonal.arctecture.application.ports.out.FindProductRepositoryPort;

import java.util.List;

public class ProductFindUseCase implements FindProductPort {

    private final FindProductRepositoryPort findRepositoryPort;

    public ProductFindUseCase(FindProductRepositoryPort findRepositoryPort) {
        this.findRepositoryPort = findRepositoryPort;
    }

    @Override
    public List<Product> findAll() {
        return this.findRepositoryPort.findAll();
    }

    @Override
    public Product findByName(String name) {
        System.out.println(name);
        return this.findRepositoryPort.findByName(name).orElseThrow();
    }
}
