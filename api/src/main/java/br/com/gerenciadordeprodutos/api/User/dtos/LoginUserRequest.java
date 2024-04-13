package br.com.gerenciadordeprodutos.api.User.dtos;

public record LoginUserRequest(
        String email,
        String password
) {
}
