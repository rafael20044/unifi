package com.unify.api.domain.comentario.service;

import com.unify.api.domain.comentario.dto.ComentarioCrear;
import com.unify.api.domain.comentario.dto.ComentarioRespuesta;

public interface IComentarioService {

    ComentarioRespuesta crear(ComentarioCrear crear);
}
