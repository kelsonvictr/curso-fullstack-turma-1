package br.com.gerenciadordeprodutos.api.Supplier.controller;

import br.com.gerenciadordeprodutos.api.Supplier.dtos.SupplierRequest;
import br.com.gerenciadordeprodutos.api.Supplier.dtos.SupplierResponse;
import br.com.gerenciadordeprodutos.api.Supplier.service.SupplierService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    @PostMapping
    public ResponseEntity<SupplierResponse> createSupplier(@Valid @RequestBody SupplierRequest supplierRequest) {
        SupplierResponse supplierResponse = supplierService.create(supplierRequest);

        return ResponseEntity.ok(supplierResponse);
    }
}
