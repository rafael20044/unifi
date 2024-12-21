package com.unify.api.domain.usuario.dto;

import com.unify.api.domain.enums.Estado;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record UsuarioCrear(

        @NotEmpty
        @NotNull
        String nombre,

        @NotEmpty
        @NotNull
        @Email
        String correo,

        @NotEmpty
        @NotNull
        String clave,

        @NotNull
        LocalDateTime fechaCreacion
) {
}
