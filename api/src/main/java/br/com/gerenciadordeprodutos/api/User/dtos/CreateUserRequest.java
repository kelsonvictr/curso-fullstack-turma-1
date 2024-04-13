package br.com.gerenciadordeprodutos.api.User.dtos;

import br.com.gerenciadordeprodutos.api.User.enums.RoleName;

public record CreateUserRequest(
        String email,
        String password,
        RoleName role
) {
}
