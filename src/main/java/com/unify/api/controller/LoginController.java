package com.unify.api.controller;


import com.unify.api.domain.usuario.dto.UsuarioCrear;
import com.unify.api.domain.usuario.dto.UsuarioRespuesta;
import com.unify.api.domain.usuario.service.UsuarioServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final UsuarioServicio servicio;

    @Autowired
    public LoginController(UsuarioServicio servicio){
        this.servicio = servicio;
    }

    @PostMapping
    public ResponseEntity<UsuarioRespuesta> crearUsuario(@RequestBody @Valid UsuarioCrear usuarioCrear,
                                                         UriComponentsBuilder builder){
        UsuarioRespuesta respuesta = servicio.crear(usuarioCrear);
        URI uri = builder.path("/usuario/{id}").buildAndExpand(respuesta.id()).toUri();
        return ResponseEntity.created(uri).body(respuesta);
    }
}
