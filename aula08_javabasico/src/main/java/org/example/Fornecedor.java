package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Fornecedor {
    private Long id;
    private String nome;
    private String telefone;
}
