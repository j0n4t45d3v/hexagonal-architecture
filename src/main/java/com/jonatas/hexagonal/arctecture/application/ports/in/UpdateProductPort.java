package com.jonatas.hexagonal.arctecture.application.ports.in;

import com.jonatas.hexagonal.arctecture.application.core.domain.Product;

public interface UpdateProductPort {

    Product update(Product product, String name);

}
