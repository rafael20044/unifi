package com.unify.api.domain.comentario.service;

import com.unify.api.domain.comentario.dto.ComentarioBuscar;
import com.unify.api.domain.comentario.dto.ComentarioCrear;
import com.unify.api.domain.comentario.dto.ComentarioRespuesta;
import com.unify.api.domain.comentario.entity.Comentario;
import com.unify.api.domain.comentario.repository.ComentarioRepository;
import com.unify.api.domain.publicacion.entity.Publicacion;
import com.unify.api.domain.publicacion.service.PublicacionService;
import com.unify.api.domain.usuario.entity.Usuario;
import com.unify.api.domain.usuario.service.UsuarioServicio;
import com.unify.api.infra.exception.NoEncontrada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComentarioService implements IComentarioService{

    private final ComentarioRepository repository;
    private final UsuarioServicio servicioUsuario;
    private final PublicacionService servicePublicacion;
    @Autowired
    public ComentarioService(ComentarioRepository repository, UsuarioServicio servicio,
                             PublicacionService servicePublicacion){
        this.repository = repository;
        this.servicioUsuario = servicio;
        this.servicePublicacion = servicePublicacion;
    }

    @Override
    public ComentarioRespuesta crear(ComentarioCrear crear) {
        Usuario usuario = servicioUsuario.buscarEntidad(crear.autor().id());
        Publicacion publicacion = servicePublicacion.buscarEntidad(crear.publicacion().id());
        Comentario comentarioPadre = null;
        if (crear.comentarioPabre() != null && crear.comentarioPabre().id() != null) {
            comentarioPadre = repository.findById(crear.comentarioPabre().id()).orElse(null);
        }
        Comentario comentario = new Comentario(crear, usuario, publicacion, comentarioPadre);
        repository.save(comentario);
        return new ComentarioRespuesta(comentario);
    }

    public ComentarioBuscar buscar(Long id){
        Comentario comentario = repository.findById(id).orElseThrow(() ->
                new NoEncontrada("Comentario no existente"));
        return new ComentarioBuscar(comentario);
    }
}
