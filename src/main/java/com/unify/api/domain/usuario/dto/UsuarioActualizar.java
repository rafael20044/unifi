package com.unify.api.domain.usuario.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record UsuarioActualizar(
        @NotNull
        Long id,


        String nombre,


        String correo,


        String clave
) {
}
