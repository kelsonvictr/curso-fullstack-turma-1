package br.com.gerenciadordeprodutos.api.Supplier.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@AllArgsConstructor
@Data
public class SupplierResponse {
    private UUID id;
    private String name;
    private String email;
    private String cnpj;
}
