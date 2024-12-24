package com.unify.api.domain.publicacion.dto;

import com.unify.api.domain.enums.EstadoPublicacion;
import com.unify.api.domain.publicacion.entity.Publicacion;
import com.unify.api.domain.usuario.dto.UsuarioRespuesta;

public record PublicacionRespuesta(
        Long id,
        UsuarioRespuesta usuarioRespuesta,
        String contenido,
        EstadoPublicacion estadoPublicacion
) {
    public PublicacionRespuesta(Publicacion publicacion) {
        this(publicacion.getId(), new UsuarioRespuesta(publicacion.getUsuario()), publicacion.getContenido(),
                publicacion.getEstado());
    }
}
