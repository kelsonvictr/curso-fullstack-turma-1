package br.com.gerenciadordeprodutos.api.Product.service;

import br.com.gerenciadordeprodutos.api.Product.dtos.ProductRequest;
import br.com.gerenciadordeprodutos.api.Product.dtos.ProductResponse;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    ProductResponse create(ProductRequest productRequest);
    List<ProductResponse> findAll();
    ProductResponse findById(UUID id);
    ProductResponse update(UUID id, @Valid ProductRequest productRequest);
    void deleteById(UUID id);
}
