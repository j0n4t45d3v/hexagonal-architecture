package com.jonatas.hexagonal.arctecture.application.core.usecase;

import com.jonatas.hexagonal.arctecture.application.core.domain.Product;
import com.jonatas.hexagonal.arctecture.application.ports.in.DeleteProductPort;
import com.jonatas.hexagonal.arctecture.application.ports.out.DeleteProductRepositoryPort;
import com.jonatas.hexagonal.arctecture.application.ports.out.FindProductRepositoryPort;

public class ProductDeleteUseCase implements DeleteProductPort {

    private final DeleteProductRepositoryPort deleteRepositoryPort;
    private final FindProductRepositoryPort findRepositoryPort;

    public ProductDeleteUseCase(DeleteProductRepositoryPort deleteRepositoryPort, FindProductRepositoryPort findRepositoryPort) {
        this.deleteRepositoryPort = deleteRepositoryPort;
        this.findRepositoryPort = findRepositoryPort;
    }

    @Override
    public void delete(String name) {
        Product product = findRepositoryPort.findByName(name).orElseThrow();
        deleteRepositoryPort.delete(product);
    }
}
