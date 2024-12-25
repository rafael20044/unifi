package com.unify.api.domain.comentario.dto;

import com.unify.api.domain.comentario.entity.Comentario;
import com.unify.api.domain.publicacion.dto.PublicacionRespuesta;
import com.unify.api.domain.usuario.dto.UsuarioRespuesta;

public record ComentarioBuscar(
        Long id,
        UsuarioRespuesta autor,
        PublicacionRespuesta publicacionOrigen,
        String contenido
) {
    public ComentarioBuscar(Comentario comentario){
        this(comentario.getId(), new UsuarioRespuesta(comentario.getUsuario()),
                new PublicacionRespuesta(comentario.getPublicacion()), comentario.getContenido());
    }
}
