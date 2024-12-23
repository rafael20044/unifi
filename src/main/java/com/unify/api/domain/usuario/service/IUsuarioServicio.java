package com.unify.api.domain.usuario.service;

import com.unify.api.domain.usuario.dto.UsuarioActualizar;
import com.unify.api.domain.usuario.dto.UsuarioBuscar;
import com.unify.api.domain.usuario.dto.UsuarioCrear;
import com.unify.api.domain.usuario.dto.UsuarioRespuesta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUsuarioServicio {

    UsuarioRespuesta crear (UsuarioCrear crear);

    UsuarioBuscar buscar(Long id);

    Page<UsuarioBuscar> buscarTodosActivos(Pageable pageable);

    UsuarioBuscar actualizar(UsuarioActualizar actualizar);

    void eliminar(Long id);
}
