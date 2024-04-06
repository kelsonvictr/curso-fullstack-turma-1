package br.com.gerenciadordeprodutos.api.Costumer.service;

import br.com.gerenciadordeprodutos.api.Costumer.dtos.CostumerRequest;
import br.com.gerenciadordeprodutos.api.Costumer.dtos.CostumerResponse;

import java.util.List;
import java.util.UUID;

public interface CostumerService {
    CostumerResponse create(CostumerRequest costumerRequest);
    CostumerResponse findById(UUID id);
    List<CostumerResponse> findAll();
    CostumerResponse update(UUID id, CostumerRequest costumerRequest);
    void deleteById(UUID id);
}
