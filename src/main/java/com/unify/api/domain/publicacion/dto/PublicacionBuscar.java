package com.unify.api.domain.publicacion.dto;

import com.unify.api.domain.enums.EstadoPublicacion;
import com.unify.api.domain.publicacion.entity.Publicacion;
import com.unify.api.domain.usuario.dto.UsuarioBuscar;

import java.time.LocalDateTime;

public record PublicacionBuscar(

        Long id,
        UsuarioBuscar usuarioBuscar,
        String contenido,
        LocalDateTime fechaCreacion,
        EstadoPublicacion estado
) {
    public PublicacionBuscar(Publicacion publicacion) {
        this(publicacion.getId(), new UsuarioBuscar(publicacion.getUsuario()), publicacion.getContenido(),
                publicacion.getFechaCreacion(), publicacion.getEstado());
    }
}
