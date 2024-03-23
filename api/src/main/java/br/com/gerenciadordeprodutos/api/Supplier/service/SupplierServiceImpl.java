package br.com.gerenciadordeprodutos.api.Supplier.service;

import br.com.gerenciadordeprodutos.api.Supplier.dtos.SupplierRequest;
import br.com.gerenciadordeprodutos.api.Supplier.dtos.SupplierResponse;
import br.com.gerenciadordeprodutos.api.Supplier.model.Supplier;
import br.com.gerenciadordeprodutos.api.Supplier.repository.SupplierRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    SupplierRepository supplierRepository;

    @Override
    public SupplierResponse create(@Valid SupplierRequest supplierRequest) {
        Supplier supplier = supplierRepository.save(new Supplier(
                UUID.randomUUID(),
                supplierRequest.getName(),
                supplierRequest.getEmail(),
                supplierRequest.getCnpj()
        ));

        return new SupplierResponse(supplier.getId(), supplier.getName(), supplier.getEmail(), supplier.getCnpj());
    }
}
