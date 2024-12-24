package com.unify.api.domain.publicacion.service;

import com.unify.api.domain.publicacion.dto.PublicacionBuscar;
import com.unify.api.domain.publicacion.dto.PublicacionCrear;
import com.unify.api.domain.publicacion.dto.PublicacionRespuesta;

public interface IPublicacionService {

    PublicacionRespuesta crear(PublicacionCrear crear);

    PublicacionBuscar buscar(Long id);
}
