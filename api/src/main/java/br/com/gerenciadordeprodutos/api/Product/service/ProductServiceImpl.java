package br.com.gerenciadordeprodutos.api.Product.service;

import br.com.gerenciadordeprodutos.api.Product.dtos.ProductRequest;
import br.com.gerenciadordeprodutos.api.Product.dtos.ProductResponse;
import br.com.gerenciadordeprodutos.api.Product.dtos.ProductSupplierDetails;
import br.com.gerenciadordeprodutos.api.Product.model.Product;
import br.com.gerenciadordeprodutos.api.Product.repository.ProductRepository;
import br.com.gerenciadordeprodutos.api.Supplier.model.Supplier;
import br.com.gerenciadordeprodutos.api.Supplier.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    SupplierRepository supplierRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public ProductResponse create(ProductRequest productRequest) {
        Supplier supplier = supplierRepository.
                findById(productRequest.getSupplierId()).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Supplier not found with id: "+productRequest.getSupplierId()));

        Product product = productRepository.save(new Product(
                UUID.randomUUID(),
                productRequest.getName(),
                productRequest.getPrice(),
                supplier,
                LocalDateTime.now()

        ));

        ProductSupplierDetails productSupplierDetails = new ProductSupplierDetails(
                supplier.getId(),
                supplier.getName()
        );

        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                productSupplierDetails,
                product.getCreatedAt()
        );

    }

    @Override
    public List<ProductResponse> findAll() {
        return productRepository.findAll().stream()
                .map(product -> new ProductResponse(
                        product.getId(),
                        product.getName(),
                        product.getPrice(),
                        new ProductSupplierDetails(
                                product.getSupplier().getId(),
                                product.getSupplier().getName()
                        ),
                        product.getCreatedAt()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponse findById(UUID id) {
        return productRepository.findById(id)
                .map(product -> new ProductResponse(
                        product.getId(),
                        product.getName(),
                        product.getPrice(),
                        new ProductSupplierDetails(
                                product.getSupplier().getId(),
                                product.getSupplier().getName()
                        ),
                        product.getCreatedAt()
                )).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Product not found with ID: " + id));
    }

    @Override
    public ProductResponse update(UUID id, ProductRequest productRequest) {
        Supplier supplier = supplierRepository.
                findById(productRequest.getSupplierId()).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Supplier not found with ID: " + productRequest.getSupplierId()));

        return productRepository.findById(id)
                .map(product -> {
                    product.setName(productRequest.getName());
                    product.setPrice(productRequest.getPrice());
                    product.setSupplier(supplier);
                    product.setCreatedAt(product.getCreatedAt());
                    productRepository.save(product);
                    return new ProductResponse(
                            product.getId(),
                            product.getName(),
                            product.getPrice(),
                            new ProductSupplierDetails(
                                    supplier.getId(),
                                    supplier.getName()
                            ),
                            product.getCreatedAt()
                    );
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Product not found with ID: " + id));
    }

    @Override
    public void deleteById(UUID id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        } else {
            throw new ResponseStatusException
                    (HttpStatus.NOT_FOUND, "Product not found with id: " + id);
        }

    }
}
