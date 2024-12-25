package com.unify.api.domain.publicacion.dto;

import com.unify.api.domain.comentario.dto.ComentarioPubicado;
import com.unify.api.domain.enums.EstadoPublicacion;
import com.unify.api.domain.publicacion.entity.Publicacion;
import com.unify.api.domain.usuario.dto.UsuarioBuscar;

import java.time.LocalDateTime;
import java.util.List;

public record PublicacionBuscar(

        Long id,
        UsuarioBuscar autor,
        String contenido,
        LocalDateTime fechaCreacion,
        EstadoPublicacion estado,
        List<ComentarioPubicado> cometarios
) {
    public PublicacionBuscar(Publicacion publicacion) {
        this(publicacion.getId(), new UsuarioBuscar(publicacion.getUsuario()), publicacion.getContenido(),
                publicacion.getFechaCreacion(), publicacion.getEstado(),
                publicacion.getComentarios().stream().map(ComentarioPubicado::new).toList());
    }
}
