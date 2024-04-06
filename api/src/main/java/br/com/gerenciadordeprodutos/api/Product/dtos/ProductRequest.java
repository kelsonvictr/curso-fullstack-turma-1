package br.com.gerenciadordeprodutos.api.Product.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
public class ProductRequest {

    private String name;

    private BigDecimal price;

    private UUID supplierId;
}
