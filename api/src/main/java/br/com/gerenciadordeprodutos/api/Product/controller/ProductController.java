package br.com.gerenciadordeprodutos.api.Product.controller;

import br.com.gerenciadordeprodutos.api.Product.dtos.ProductRequest;
import br.com.gerenciadordeprodutos.api.Product.dtos.ProductResponse;
import br.com.gerenciadordeprodutos.api.Product.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse create(@Valid @RequestBody ProductRequest productRequest) {
        return productService.create(productRequest);
    }

}
