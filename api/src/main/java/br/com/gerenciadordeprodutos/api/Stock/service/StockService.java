package br.com.gerenciadordeprodutos.api.Stock.service;

import br.com.gerenciadordeprodutos.api.Stock.dtos.SaleRequest;
import br.com.gerenciadordeprodutos.api.Stock.dtos.SaleResponse;
import br.com.gerenciadordeprodutos.api.Stock.dtos.StockRequest;
import br.com.gerenciadordeprodutos.api.Stock.dtos.StockResponse;

public interface StockService {
    StockResponse create(StockRequest stockRequest);
    SaleResponse sell(SaleRequest saleRequest);
}
