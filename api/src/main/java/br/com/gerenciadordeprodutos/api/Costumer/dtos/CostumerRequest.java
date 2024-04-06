package br.com.gerenciadordeprodutos.api.Costumer.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CostumerRequest {

    private String name;
    private String cpf;
    private String email;
    private CostumerAddressRequest costumerAddressRequest;
}
