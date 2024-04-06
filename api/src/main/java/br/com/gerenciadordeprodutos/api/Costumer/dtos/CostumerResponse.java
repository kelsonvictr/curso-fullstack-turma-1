package br.com.gerenciadordeprodutos.api.Costumer.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@Data
public class CostumerResponse {
    private UUID id;
    private String name;
    private String cpf;
    private String email;
    private CostumerAddressResponse costumerAddressResponse;
    private LocalDateTime createdAt;
}
