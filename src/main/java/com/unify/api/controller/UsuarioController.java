package com.unify.api.controller;

import com.unify.api.domain.usuario.dto.UsuarioActualizar;
import com.unify.api.domain.usuario.dto.UsuarioBuscar;
import com.unify.api.domain.usuario.service.UsuarioServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping
    public ResponseEntity<UsuarioBuscar> actualizar(@RequestBody @Valid UsuarioActualizar actualizar){
        UsuarioBuscar buscar = servicio.actualizar(actualizar);
        return ResponseEntity.ok(buscar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrar(@PathVariable Long id){
        servicio.eliminar(id);
        return ResponseEntity.ok().build();
    }
}
