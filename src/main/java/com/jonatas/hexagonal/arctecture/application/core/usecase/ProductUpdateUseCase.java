package com.jonatas.hexagonal.arctecture.application.core.usecase;

import com.jonatas.hexagonal.arctecture.application.core.domain.Product;
import com.jonatas.hexagonal.arctecture.application.ports.in.UpdateProductPort;
import com.jonatas.hexagonal.arctecture.application.ports.out.FindProductRepositoryPort;
import com.jonatas.hexagonal.arctecture.application.ports.out.SaveProductRepositoryPort;
import org.modelmapper.ModelMapper;

public class ProductUpdateUseCase implements UpdateProductPort {

    private final SaveProductRepositoryPort saveRepository;
    private final FindProductRepositoryPort findRepository;
    private final ModelMapper modelMapper;

    public ProductUpdateUseCase(SaveProductRepositoryPort saveRepository, FindProductRepositoryPort findRepository, ModelMapper modelMapper) {
        this.saveRepository = saveRepository;
        this.findRepository = findRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Product update(Product product, String name) {
        Product productFound = this.findRepository.findByName(name).orElseThrow();

        this.modelMapper.map(product, productFound);

        return saveRepository.save(productFound);
    }
}
