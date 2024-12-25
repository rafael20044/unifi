package com.unify.api.domain.comentario.dto;

import com.unify.api.domain.comentario.entity.Comentario;
import com.unify.api.domain.usuario.dto.UsuarioRespuesta;

public record ComentarioPubicado(
        Long id,
        UsuarioRespuesta autor,
        String contenido
) {
    public ComentarioPubicado(Comentario comentario){
        this(comentario.getId(), new UsuarioRespuesta(comentario.getUsuario()), comentario.getContenido());
    }
}
