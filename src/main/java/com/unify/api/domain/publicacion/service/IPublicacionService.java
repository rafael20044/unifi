package com.unify.api.domain.publicacion.service;

import com.unify.api.domain.publicacion.dto.PublicacionBuscar;
import com.unify.api.domain.publicacion.dto.PublicacionCrear;
import com.unify.api.domain.publicacion.dto.PublicacionRespuesta;
import com.unify.api.domain.publicacion.entity.Publicacion;

public interface IPublicacionService {

    PublicacionRespuesta crear(PublicacionCrear crear);

    PublicacionBuscar buscar(Long id);

    Publicacion buscarEntidad(Long id);
}
