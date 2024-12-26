package com.unify.api.controller;

import com.unify.api.domain.comentario.dto.ComentarioBuscar;
import com.unify.api.domain.comentario.dto.ComentarioCrear;
import com.unify.api.domain.comentario.dto.ComentarioRespuesta;
import com.unify.api.domain.comentario.service.ComentarioService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/cometario")
public class ComentarioController {

    private final ComentarioService service;

    @Autowired
    public ComentarioController(ComentarioService service){
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

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<ComentarioBuscar> buscar(@PathVariable Long id){
        ComentarioBuscar buscar = service.buscar(id);
        return ResponseEntity.ok(buscar);
    }
}
