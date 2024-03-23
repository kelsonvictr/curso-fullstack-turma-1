package br.com.gerenciadordeprodutos.api.Supplier.service;

import br.com.gerenciadordeprodutos.api.Supplier.dtos.SupplierRequest;
import br.com.gerenciadordeprodutos.api.Supplier.dtos.SupplierResponse;

public interface SupplierService {
    SupplierResponse create(SupplierRequest supplierRequest);
}
