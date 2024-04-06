package br.com.gerenciadordeprodutos.api.Costumer.service;

import br.com.gerenciadordeprodutos.api.Costumer.dtos.CostumerAddressResponse;
import br.com.gerenciadordeprodutos.api.Costumer.dtos.CostumerRequest;
import br.com.gerenciadordeprodutos.api.Costumer.dtos.CostumerResponse;
import br.com.gerenciadordeprodutos.api.Costumer.model.Costumer;
import br.com.gerenciadordeprodutos.api.Costumer.model.CostumerAddress;
import br.com.gerenciadordeprodutos.api.Costumer.repository.CostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class CostumerServiceImpl implements CostumerService {

    @Autowired
    CostumerRepository costumerRepository;

    @Override
    public CostumerResponse create(CostumerRequest costumerRequest) {
        Costumer costumer = new Costumer(
                UUID.randomUUID(),
                costumerRequest.getName(),
                costumerRequest.getCpf(),
                costumerRequest.getEmail(),
                null,
                LocalDateTime.now()
        );

        CostumerAddress costumerAddress = new CostumerAddress(
                UUID.randomUUID(),
                costumerRequest.getCostumerAddressRequest().getStreet(),
                costumerRequest.getCostumerAddressRequest().getNumber(),
                costumerRequest.getCostumerAddressRequest().getNeighborhood(),
                costumerRequest.getCostumerAddressRequest().getCity(),
                costumerRequest.getCostumerAddressRequest().getState(),
                costumerRequest.getCostumerAddressRequest().getCountry(),
                costumerRequest.getCostumerAddressRequest().getZipCode(),
                costumer
        );

        costumer.setAddress(costumerAddress);

        Costumer savedCostumer = costumerRepository.save(costumer);

        return new CostumerResponse(
                savedCostumer.getId(),
                savedCostumer.getName(),
                savedCostumer.getCpf(),
                savedCostumer.getEmail(),
                new CostumerAddressResponse(
                        savedCostumer.getAddress().getStreet(),
                        savedCostumer.getAddress().getNumber(),
                        savedCostumer.getAddress().getNeighborhood(),
                        savedCostumer.getAddress().getCity(),
                        savedCostumer.getAddress().getState(),
                        savedCostumer.getAddress().getCountry(),
                        savedCostumer.getAddress().getZipCode()
                ),
                savedCostumer.getCreatedAt()
        );
    }

    @Override
    public CostumerResponse findById(UUID id) {
        return null;
    }

    @Override
    public List<CostumerResponse> findAll() {
        return null;
    }

    @Override
    public CostumerResponse update(UUID id, CostumerRequest costumerRequest) {
        return null;
    }

    @Override
    public void deleteById(UUID id) {

    }
}
