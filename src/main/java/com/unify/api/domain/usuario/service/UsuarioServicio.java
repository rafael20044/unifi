package com.unify.api.domain.usuario.service;

import com.unify.api.domain.usuario.dto.UsuarioBuscar;
import com.unify.api.domain.usuario.dto.UsuarioCrear;
import com.unify.api.domain.usuario.dto.UsuarioRespuesta;
import com.unify.api.domain.usuario.entity.Usuario;
import com.unify.api.domain.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UsuarioServicio implements IUsuarioServicio{

    private final UsuarioRepository repository;

    @Autowired
    public UsuarioServicio(UsuarioRepository repository){
        this.repository = repository;
    }

    @Override
    public UsuarioRespuesta crear(UsuarioCrear crear) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String passEncoder = encoder.encode(crear.clave());
        Usuario usuario = new Usuario(crear, passEncoder);
        repository.save(usuario);
        return new UsuarioRespuesta(usuario);
    }

    @Override
    public UsuarioBuscar buscar(Long id) {
        Usuario usuario = repository.findById(id).orElseThrow(()->new RuntimeException("No encontrado"));
        return new UsuarioBuscar(usuario);
    }
}
