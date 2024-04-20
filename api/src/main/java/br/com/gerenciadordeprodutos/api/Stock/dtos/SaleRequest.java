package br.com.gerenciadordeprodutos.api.Stock.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class SaleRequest {
    private UUID productId;
    private Integer quantity;
}
