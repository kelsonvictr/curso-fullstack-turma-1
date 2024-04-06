package br.com.gerenciadordeprodutos.api.Product.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@Data
public class ProductResponse {
    private UUID id;
    private String name;
    private BigDecimal price;
    private ProductSupplierDetails productSupplierDetails;
    private LocalDateTime createdAt;
}
