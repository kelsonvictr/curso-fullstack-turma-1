package br.com.gerenciadordeprodutos.api.Stock.service;

import br.com.gerenciadordeprodutos.api.Product.dtos.ProductResponse;
import br.com.gerenciadordeprodutos.api.Product.dtos.ProductSupplierDetails;
import br.com.gerenciadordeprodutos.api.Product.model.Product;
import br.com.gerenciadordeprodutos.api.Product.repository.ProductRepository;
import br.com.gerenciadordeprodutos.api.Product.service.ProductService;
import br.com.gerenciadordeprodutos.api.Stock.dtos.SaleRequest;
import br.com.gerenciadordeprodutos.api.Stock.dtos.SaleResponse;
import br.com.gerenciadordeprodutos.api.Stock.dtos.StockRequest;
import br.com.gerenciadordeprodutos.api.Stock.dtos.StockResponse;
import br.com.gerenciadordeprodutos.api.Stock.model.Stock;
import br.com.gerenciadordeprodutos.api.Stock.repository.StockRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    StockRepository stockRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public StockResponse create(StockRequest stockRequest) {
        // Buscar o produto pelo ID
        Product product = productRepository.findById(stockRequest.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + stockRequest.getProductId()));

        // Criar uma nova entrada de estoque para o produto
        Stock stock = new Stock();
        stock.setProduct(product);
        stock.setQuantity(stockRequest.getQuantity());
        stock = stockRepository.save(stock);

        // Criar uma resposta de estoque
        StockResponse stockResponse = new StockResponse(
                stock.getId(),
                new ProductResponse(
                        product.getId(),
                        product.getName(),
                        product.getPrice(),
                        new ProductSupplierDetails(
                                product.getSupplier().getId(),
                                product.getSupplier().getName()
                        ),
                        product.getCreatedAt()
                ),
                stock.getQuantity()
        );

        return stockResponse;
    }

    @Override
    @Transactional
    public SaleResponse sell(SaleRequest saleRequest) {
        // Buscar o estoque do produto pelo ID do produto
        Stock stock = stockRepository.findByProductId(saleRequest.getProductId())
                .orElseThrow(() -> new RuntimeException("Stock not found for product ID: " + saleRequest.getProductId()));

        // Verificar se a quantidade solicitada está disponível no estoque
        if (stock.getQuantity() < saleRequest.getQuantity()) {
            throw new RuntimeException("Insufficient stock for product ID: " + saleRequest.getProductId());
        }

        // Decrementar a quantidade no estoque
        stock.setQuantity(stock.getQuantity() - saleRequest.getQuantity());
        stockRepository.save(stock);

        // Criar uma resposta de venda
        Product product = stock.getProduct();
        SaleResponse saleResponse = new SaleResponse(
                product.getId(),
                product.getName(),
                saleRequest.getQuantity(),
                product.getPrice().multiply(BigDecimal.valueOf(saleRequest.getQuantity())),
                LocalDateTime.now()
        );

        return saleResponse;
    }
}
