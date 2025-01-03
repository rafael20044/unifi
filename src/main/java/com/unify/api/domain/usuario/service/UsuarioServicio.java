package com.unify.api.domain.usuario.service;

import com.unify.api.domain.usuario.dto.UsuarioActualizar;
import com.unify.api.domain.usuario.dto.UsuarioBuscar;
import com.unify.api.domain.usuario.dto.UsuarioCrear;
import com.unify.api.domain.usuario.dto.UsuarioRespuesta;
import com.unify.api.domain.usuario.entity.Usuario;
import com.unify.api.domain.usuario.repository.UsuarioRepository;
import com.unify.api.infra.exception.CorreoRepetido;
import com.unify.api.infra.exception.NoEncontrada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UsuarioServicio implements IUsuarioServicio{

    private final UsuarioRepository repository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    public UsuarioServicio(UsuarioRepository repository){
        this.repository = repository;
    }

    @Override
    public UsuarioRespuesta crear(UsuarioCrear crear) {
        Optional<Usuario> verificarCorreo = repository.findByCorreo(crear.correo());
        if (verificarCorreo.isEmpty()) {
            String passEncoder = encoder.encode(crear.clave());
            Usuario usuario = new Usuario(crear, passEncoder);
            repository.save(usuario);
            return new UsuarioRespuesta(usuario);
        }
        throw new CorreoRepetido("Usuario exsitente");
    }

    @Override
    public UsuarioBuscar buscar(Long id) {
        Usuario usuario = repository.findById(id).orElseThrow(()->
                new NoEncontrada("No existe un usario con el id: " + id));
        return new UsuarioBuscar(usuario);
    }

    @Override
    public Page<UsuarioBuscar> buscarTodosActivos(Pageable pageable) {
        return repository.buscarTodosActivos(pageable).map(UsuarioBuscar::new);
    }

    @Override
    public UsuarioBuscar actualizar(UsuarioActualizar actualizar) {
        Usuario u = repository.findById(actualizar.id()).orElseThrow(() ->
                new NoEncontrada("Usuario no existente"));
        Optional<Usuario> verificarCorreo = repository.findByCorreo(actualizar.correo());
        if (verificarCorreo.isEmpty()) {
            String passEncoder = actualizar.clave() != null ? encoder.encode(actualizar.clave()) : null;
            u.actualizar(actualizar, passEncoder);
            repository.save(u);
            return new UsuarioBuscar(u);
        }
        throw new CorreoRepetido("Correo exitente");
    }

    @Override
    public void eliminar(Long id) {
        Usuario usuario = repository.findById(id).orElseThrow(() -> new NoEncontrada("Usuario no existente"));
        usuario.ponerInactivo();
        repository.save(usuario);
    }

    @Override
    public Usuario buscarEntidad(Long id) {
        return repository.findById(id).orElseThrow(() -> new NoEncontrada("Usuario no existente"));
    }
}
