package com.unify.api.domain.usuario.service;

import com.unify.api.domain.usuario.dto.UsuarioBuscar;
import com.unify.api.domain.usuario.dto.UsuarioCrear;
import com.unify.api.domain.usuario.dto.UsuarioRespuesta;

public interface IUsuarioServicio {

    UsuarioRespuesta crear (UsuarioCrear crear);

    UsuarioBuscar buscar(Long id);
}
