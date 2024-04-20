package br.com.gerenciadordeprodutos.api.Stock.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
public class SaleResponse {
    private UUID productId;
    private String productName;
    private Integer quantitySold;
    private BigDecimal totalAmount;
    private LocalDateTime saleDate;
}