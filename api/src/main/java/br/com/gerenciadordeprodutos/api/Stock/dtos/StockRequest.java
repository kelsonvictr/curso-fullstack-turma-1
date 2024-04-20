package br.com.gerenciadordeprodutos.api.Stock.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class StockRequest {
    private UUID productId;
    private Integer quantity;
}
