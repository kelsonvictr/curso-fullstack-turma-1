package br.com.gerenciadordeprodutos.api.User.dtos;

import br.com.gerenciadordeprodutos.api.User.model.Role;

import java.util.List;
import java.util.UUID;

public record RecoveryUserDto(
        UUID id,
        String email,
        List<Role> roles
) {
}
