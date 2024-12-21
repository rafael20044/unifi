package com.unify.api.domain.usuario.dto;

import com.unify.api.domain.usuario.entity.Usuario;

public record UsuarioRespuesta(

        Long id,
        String nombre
) {
    public UsuarioRespuesta(Usuario usuario) {
        this(usuario.getId(), usuario.getNombre());
    }
}
