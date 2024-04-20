package br.com.gerenciadordeprodutos.api.Stock.dtos;

import br.com.gerenciadordeprodutos.api.Product.dtos.ProductResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class StockResponse {
    private UUID id;
    private ProductResponse productResponse;
    private Integer quantity;

}
