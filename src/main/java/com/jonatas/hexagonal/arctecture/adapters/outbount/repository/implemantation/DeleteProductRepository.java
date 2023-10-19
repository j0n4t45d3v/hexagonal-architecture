package com.jonatas.hexagonal.arctecture.adapters.outbount.repository.implemantation;

import com.jonatas.hexagonal.arctecture.adapters.inbount.entity.ProductEntity;
import com.jonatas.hexagonal.arctecture.adapters.inbount.mapper.ProductToProductEntity;
import com.jonatas.hexagonal.arctecture.adapters.outbount.repository.ProductRepository;
import com.jonatas.hexagonal.arctecture.application.core.domain.Product;
import com.jonatas.hexagonal.arctecture.application.ports.out.DeleteProductRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteProductRepository implements DeleteProductRepositoryPort {

    private final ProductRepository productRepository;
    private final ProductToProductEntity productToProductEntity;

    @Override
    public void delete(Product product) {
        ProductEntity parseProductForProductEntity = productToProductEntity.map(product);
        this.productRepository.delete(parseProductForProductEntity);
    }
}
