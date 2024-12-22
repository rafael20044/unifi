package com.unify.api.domain.usuario.dto;

import com.unify.api.domain.enums.Estado;
import com.unify.api.domain.usuario.entity.Usuario;

public record UsuarioBuscar(
        Long id,
        String nombre,
        String correo,
        Estado estado
) {
    public UsuarioBuscar(Usuario usuario) {
        this(usuario.getId(), usuario.getNombre(), usuario.getCorreo(), usuario.getEstado());
    }
}
