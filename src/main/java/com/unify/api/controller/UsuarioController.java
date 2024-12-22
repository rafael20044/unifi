package com.unify.api.controller;

import com.unify.api.domain.usuario.dto.UsuarioBuscar;
import com.unify.api.domain.usuario.service.UsuarioServicio;
import org.aspectj.apache.bcel.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioServicio servicio;

    @Autowired
    public UsuarioController(UsuarioServicio servicio){
        this.servicio = servicio;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioBuscar> buscarPorID(@PathVariable Long id){
        UsuarioBuscar buscar = servicio.buscar(id);
        return ResponseEntity.ok(buscar);
    }

    @GetMapping
    public ResponseEntity<Page<UsuarioBuscar>> buscarTodos(Pageable pageable){
        Page<UsuarioBuscar> lista = servicio.buscarTodosActivos(pageable);
        return ResponseEntity.ok(lista);
    }
}
