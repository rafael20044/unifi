package com.unify.api.domain.usuario.entity;

import com.unify.api.domain.enums.Estado;
import com.unify.api.domain.usuario.dto.UsuarioActualizar;
import com.unify.api.domain.usuario.dto.UsuarioCrear;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name = "USUARIO")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String correo;

    private String clave;

    private LocalDateTime fechaCreacion;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    public Usuario(UsuarioCrear crear, String claveEncoded){
        this.nombre = crear.nombre();
        this.correo = crear.correo();
        this.clave = claveEncoded;
        this.fechaCreacion = crear.fechaCreacion();
        this.estado = Estado.ACTIVO;
    }

    public void actualizar(UsuarioActualizar actualizar, String pass){
        if (actualizar.nombre() != null) {
            this.nombre = actualizar.nombre();
        }
        if (actualizar.correo() != null) {
            this.correo = actualizar.correo();
        }
        if (pass != null) {
            this.clave = pass;
        }
    }

    public void ponerInactivo(){
        this.estado = Estado.INACTIVO;
    }
}
