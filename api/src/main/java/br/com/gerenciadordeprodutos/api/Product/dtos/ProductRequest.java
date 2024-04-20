package br.com.gerenciadordeprodutos.api.Product.dtos;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
public class ProductRequest {

    @NotBlank(message = "Nome é obrigatório")
    private String name;

    @NotNull(message = "Preço é obrigatório")
    @DecimalMin(value = "0.01", message = "O preço deve ser no mínimo R$0.01")
    private BigDecimal price;

    private UUID supplierId;
}
