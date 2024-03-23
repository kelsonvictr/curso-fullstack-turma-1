package br.com.gerenciadordeprodutos.api.Supplier.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import org.hibernate.validator.constraints.br.CNPJ;

@Getter
public class SupplierRequest {

    @NotBlank(message = "Name is mandatory")
    private String name;

    @CNPJ(message = "Invalid CNPJ")
    private String cnpj;

    @Email(message = "Invalid email address")
    private String email;
}
