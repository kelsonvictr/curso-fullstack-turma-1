package br.com.gerenciadordeprodutos.api.Product.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@AllArgsConstructor
@Data
public class ProductSupplierDetails {
    private UUID id;
    private String name;
}
