package com.jonatas.hexagonal.arctecture.config;

import com.jonatas.hexagonal.arctecture.adapters.outbount.repository.implemantation.DeleteProductRepository;
import com.jonatas.hexagonal.arctecture.adapters.outbount.repository.implemantation.FindProductRepository;
import com.jonatas.hexagonal.arctecture.adapters.outbount.repository.implemantation.SaveProductRepository;
import com.jonatas.hexagonal.arctecture.application.core.usecase.ProductCreateUseCase;
import com.jonatas.hexagonal.arctecture.application.core.usecase.ProductDeleteUseCase;
import com.jonatas.hexagonal.arctecture.application.core.usecase.ProductFindUseCase;
import com.jonatas.hexagonal.arctecture.application.core.usecase.ProductUpdateUseCase;
import com.jonatas.hexagonal.arctecture.application.ports.in.CreateProductPort;
import com.jonatas.hexagonal.arctecture.application.ports.in.DeleteProductPort;
import com.jonatas.hexagonal.arctecture.application.ports.in.FindProductPort;
import com.jonatas.hexagonal.arctecture.application.ports.in.UpdateProductPort;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateBeans {

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setSkipNullEnabled(true);
        return mapper;
    }

    @Bean
    public CreateProductPort createProductPort(SaveProductRepository repository){
        return new ProductCreateUseCase(repository);
    }

    @Bean
    public FindProductPort findAProductPort(FindProductRepository findRepository){
        return new ProductFindUseCase(findRepository);
    }

    @Bean
    public UpdateProductPort updateProductPort(
            SaveProductRepository saveRepository,
            FindProductRepository findRepository,
            ModelMapper modelMapper
    ){
        return new ProductUpdateUseCase(saveRepository, findRepository, modelMapper);
    }

    @Bean
    public DeleteProductPort deleteProductPort(DeleteProductRepository deleteRepository, FindProductRepository findRepository){
        return new ProductDeleteUseCase(deleteRepository, findRepository);
    }
}
