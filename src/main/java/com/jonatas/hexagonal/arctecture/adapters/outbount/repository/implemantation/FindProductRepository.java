package com.jonatas.hexagonal.arctecture.adapters.outbount.repository.implemantation;

import com.jonatas.hexagonal.arctecture.adapters.inbount.entity.ProductEntity;
import com.jonatas.hexagonal.arctecture.adapters.inbount.mapper.ProductEntityToProduct;
import com.jonatas.hexagonal.arctecture.adapters.outbount.repository.ProductRepository;
import com.jonatas.hexagonal.arctecture.application.core.domain.Product;
import com.jonatas.hexagonal.arctecture.application.ports.out.FindProductRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindProductRepository implements FindProductRepositoryPort {

    private final ProductRepository productRepository;
    private final ProductEntityToProduct productEntityToProduct;

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        List<ProductEntity> findAllProductEntity = this.productRepository.findAll();

        return findAllProductEntity
                .stream()
                .map(productEntityToProduct::map)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> findByName(String name) {
        Optional<ProductEntity> productEntityFound  = this.productRepository.findByName(name).stream().findFirst();
        return productEntityFound.map(productEntityToProduct::map);
    }
}
