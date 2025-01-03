package com.unify.api.domain.publicacion.service;

import com.unify.api.domain.comentario.entity.Comentario;
import com.unify.api.domain.publicacion.dto.PublicacionBuscar;
import com.unify.api.domain.publicacion.dto.PublicacionCrear;
import com.unify.api.domain.publicacion.dto.PublicacionEditar;
import com.unify.api.domain.publicacion.dto.PublicacionRespuesta;
import com.unify.api.domain.publicacion.entity.Publicacion;
import com.unify.api.domain.publicacion.repository.PublicacionRespository;
import com.unify.api.domain.usuario.entity.Usuario;
import com.unify.api.domain.usuario.service.UsuarioServicio;
import com.unify.api.infra.exception.NoEncontrada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublicacionService implements IPublicacionService{

    private final PublicacionRespository respository;
    private final UsuarioServicio servicio;

    @Autowired
    public PublicacionService(PublicacionRespository repository, UsuarioServicio servicio){
        this.respository = repository;
        this.servicio = servicio;
    }

    @Override
    public PublicacionRespuesta crear(PublicacionCrear crear) {
        Usuario usuario = servicio.buscarEntidad(crear.usuarioPublicacion().id());
        Publicacion publicacion = new Publicacion(crear, usuario);
        respository.save(publicacion);
        return new PublicacionRespuesta(publicacion);
    }

    @Override
    public PublicacionBuscar buscar(Long id) {
        Publicacion publicacion = respository.findById(id).orElseThrow(() ->
                new NoEncontrada("Publicacion no existente"));
        return new PublicacionBuscar(publicacion);
    }

    @Override
    public Publicacion buscarEntidad(Long id) {
        return respository.findById(id).orElseThrow(() ->
                new NoEncontrada("Publicacion no existente"));
    }

    @Override
    public void agregarCometario(Comentario cometario) {
        Publicacion publicacion = cometario.getPublicacion();
        publicacion.agregarCometario(cometario);
        respository.save(publicacion);
    }

    @Override
    public PublicacionBuscar editar(PublicacionEditar editar) {
        Publicacion publicacion = respository.findById(editar.id()).orElseThrow(() ->
                new NoEncontrada("Publicacion no encontrada"));
        publicacion.actualizar(editar);
        respository.save(publicacion);
        return new PublicacionBuscar(publicacion);
    }

    @Override
    public void borrar(Long id) {
        respository.deleteById(id);
    }
}
