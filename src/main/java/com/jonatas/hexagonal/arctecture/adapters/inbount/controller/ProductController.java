package com.jonatas.hexagonal.arctecture.adapters.inbount.controller;

import com.jonatas.hexagonal.arctecture.adapters.inbount.entity.ProductEntity;
import com.jonatas.hexagonal.arctecture.adapters.inbount.mapper.ProductEntityToProduct;
import com.jonatas.hexagonal.arctecture.application.core.domain.Product;
import com.jonatas.hexagonal.arctecture.application.ports.in.CreateProductPort;
import com.jonatas.hexagonal.arctecture.application.ports.in.DeleteProductPort;
import com.jonatas.hexagonal.arctecture.application.ports.in.FindProductPort;
import com.jonatas.hexagonal.arctecture.application.ports.in.UpdateProductPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final CreateProductPort createProductPort;
    private final FindProductPort findAllProductPort;
    private final UpdateProductPort updateProductPort;
    private final DeleteProductPort deleteProductPort;
    private final ProductEntityToProduct productEntityToProduct;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(findAllProductPort.findAll());
    }

    @GetMapping("/{name}")
    public ResponseEntity<Product> findByName(@PathVariable("name") String name) {
        return ResponseEntity.ok(findAllProductPort.findByName(name));
    }

    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody ProductEntity productEntity) {
        Product product = createProductPort.createProduct(
                productEntity.getName(),
                productEntity.getDescription(),
                productEntity.getPrice(),
                productEntity.getQuantity()
        );
        URI uri = UriComponentsBuilder.fromPath("/products/{name}").buildAndExpand(product.getName()).toUri();
        return ResponseEntity.created(uri).body(product);
    }

    @PutMapping("/update/{name}")
    public ResponseEntity<Product> updateProduct(@PathVariable("name") String name, @RequestBody ProductEntity productEntity) {
        Product product = productEntityToProduct.map(productEntity);
        Product productUpdated = updateProductPort.update(product, name);
        return ResponseEntity.ok(productUpdated);
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("name") String name) {
        deleteProductPort.delete(name);
        return ResponseEntity.ok().build();
    }
}
