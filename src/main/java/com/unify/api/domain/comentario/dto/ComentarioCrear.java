package com.unify.api.domain.comentario.dto;

import com.unify.api.domain.publicacion.dto.PublicacionComentario;
import com.unify.api.domain.usuario.dto.UsuarioComentario;
import jakarta.validation.constraints.NotNull;

public record ComentarioCrear(

        @NotNull
        UsuarioComentario autor,

        @NotNull
        PublicacionComentario publicacion,

        ComentarioPabre comentarioPabre,

        @NotNull
        String contenido

) {
}
