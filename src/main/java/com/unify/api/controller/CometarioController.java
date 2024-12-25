package com.unify.api.controller;

import com.unify.api.domain.comentario.dto.ComentarioCrear;
import com.unify.api.domain.comentario.dto.ComentarioRespuesta;
import com.unify.api.domain.comentario.service.ComentarioService;
import jakarta.transaction.Transactional;
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
@RequestMapping("/cometario")
public class CometarioController {

    private final ComentarioService service;

    @Autowired
    public CometarioController(ComentarioService service){
        this.service = service;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ComentarioRespuesta> crear(@RequestBody @Valid ComentarioCrear crear,
                                                     UriComponentsBuilder builder){
        ComentarioRespuesta respuesta = service.crear(crear);
        URI uri = builder.path("/cometario/{id}").buildAndExpand(respuesta.id()).toUri();
        return ResponseEntity.created(uri).body(respuesta);
    }
}
