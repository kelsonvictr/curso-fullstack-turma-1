package br.com.gerenciadordeprodutos.api.Costumer.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CostumerAddressResponse {
    private String street;

    private String number;

    private String neighborhood;

    private String city;

    private String state;

    private String country;

    private String zipCode;
}
