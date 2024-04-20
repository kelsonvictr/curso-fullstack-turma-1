package br.com.gerenciadordeprodutos.api.Costumer.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@AllArgsConstructor
@Data
public class CostumerRequest {

    @NotBlank(message = "Nome é obrigatório")
    private String name;

    @CPF(message = "CPF inválido")
    private String cpf;

    @Email(message = "Email inválido")
    private String email;

    private CostumerAddressRequest costumerAddressRequest;
}
