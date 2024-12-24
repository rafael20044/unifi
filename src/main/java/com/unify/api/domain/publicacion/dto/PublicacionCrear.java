package com.unify.api.domain.publicacion.dto;

import com.unify.api.domain.usuario.dto.UsuarioPublicacion;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record PublicacionCrear(
        @NotNull
        UsuarioPublicacion usuarioPublicacion,

        @NotNull
        @NotEmpty
        String contenido
) {
}
