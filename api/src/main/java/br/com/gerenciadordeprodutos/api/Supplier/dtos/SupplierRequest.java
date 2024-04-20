package br.com.gerenciadordeprodutos.api.Supplier.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import org.hibernate.validator.constraints.br.CNPJ;

@Getter
public class SupplierRequest {

    @NotBlank(message = "Nome é obrigatório")
    private String name;

    @CNPJ(message = "CNPJ inválido")
    private String cnpj;

    @Email(message = "Email inválido")
    private String email;
}
