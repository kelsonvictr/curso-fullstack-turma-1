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
        return null;
    }

    @Override
    public ProductResponse findById(UUID id) {
        return null;
    }

    @Override
    public ProductResponse update(UUID id, ProductRequest productRequest) {
        return null;
    }

    @Override
    public void deleteById(UUID id) {

    }
}
