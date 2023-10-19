package com.jonatas.hexagonal.arctecture.adapters.outbount.repository.implemantation;

import com.jonatas.hexagonal.arctecture.adapters.inbount.entity.ProductEntity;
import com.jonatas.hexagonal.arctecture.adapters.inbount.mapper.ProductEntityToProduct;
import com.jonatas.hexagonal.arctecture.adapters.inbount.mapper.ProductToProductEntity;
import com.jonatas.hexagonal.arctecture.adapters.outbount.repository.ProductRepository;
import com.jonatas.hexagonal.arctecture.application.core.domain.Product;
import com.jonatas.hexagonal.arctecture.application.ports.out.SaveProductRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class SaveProductRepository implements SaveProductRepositoryPort {

    private final ProductRepository productRepository;
    private final ProductToProductEntity productToProductEntity;
    private final ProductEntityToProduct productEntityToProduct;

    @Override
    @Transactional
    public Product save(Product product) {
        ProductEntity parseProductForEntity = productToProductEntity.map(product);
        ProductEntity productEntitySaved = productRepository.save(parseProductForEntity);
        return productEntityToProduct.map(productEntitySaved);
    }
}
