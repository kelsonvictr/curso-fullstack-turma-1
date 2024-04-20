package br.com.gerenciadordeprodutos.api.Stock.controller;

import br.com.gerenciadordeprodutos.api.Product.dtos.ProductRequest;
import br.com.gerenciadordeprodutos.api.Product.dtos.ProductResponse;
import br.com.gerenciadordeprodutos.api.Stock.dtos.SaleRequest;
import br.com.gerenciadordeprodutos.api.Stock.dtos.SaleResponse;
import br.com.gerenciadordeprodutos.api.Stock.dtos.StockRequest;
import br.com.gerenciadordeprodutos.api.Stock.dtos.StockResponse;
import br.com.gerenciadordeprodutos.api.Stock.service.StockService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stock")
@RolesAllowed({"ROLE_ADMINISTRATOR", "ROLE_MANAGER"})
public class StockController {

    @Autowired
    StockService stockService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StockResponse create(@Valid @RequestBody StockRequest stockRequest) {
        return stockService.create(stockRequest);
    }

    @PostMapping("/sell")
    @ResponseStatus(HttpStatus.CREATED)
    public SaleResponse sell(@Valid @RequestBody SaleRequest saleRequest) {
        return stockService.sell(saleRequest);
    }

}
