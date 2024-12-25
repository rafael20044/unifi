package com.unify.api.controller;

import com.unify.api.domain.publicacion.dto.PublicacionBuscar;
import com.unify.api.domain.publicacion.dto.PublicacionCrear;
import com.unify.api.domain.publicacion.dto.PublicacionRespuesta;
import com.unify.api.domain.publicacion.entity.Publicacion;
import com.unify.api.domain.publicacion.service.PublicacionService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/publicacion")
public class PublicacionController {

    private final PublicacionService service;

    @Autowired
    public PublicacionController(PublicacionService service){
        this.service = service;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<PublicacionRespuesta> crear(@RequestBody @Valid PublicacionCrear crear,
                                                      UriComponentsBuilder builder){
        PublicacionRespuesta respuesta = service.crear(crear);
        URI uri = builder.path("/publicacion/{id}").buildAndExpand(respuesta.id()).toUri();
        return ResponseEntity.created(uri).body(respuesta);
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<PublicacionBuscar> buscar(@PathVariable Long id){
        PublicacionBuscar buscar = service.buscar(id);
        return ResponseEntity.ok(buscar);
    }
}
