package br.com.gerenciadordeprodutos.api.Product.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
public class ProductRequest {

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Price is mandatory")
    private BigDecimal price;

    @NotBlank(message = "Supplier is mandatory")
    private UUID supplierId;
}
