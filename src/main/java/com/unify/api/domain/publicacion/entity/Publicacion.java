package com.unify.api.domain.publicacion.entity;

import com.unify.api.domain.comentario.entity.Comentario;
import com.unify.api.domain.enums.EstadoPublicacion;
import com.unify.api.domain.publicacion.dto.PublicacionCrear;
import com.unify.api.domain.publicacion.dto.PublicacionEditar;
import com.unify.api.domain.reaccion.entity.Reaccion;
import com.unify.api.domain.usuario.entity.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Publicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "publicacion")
    private List<Comentario> comentarios;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "publicacion")
    private List<Reaccion> reacciones;

    @Column(length = 500)
    private String contenido;

    private LocalDateTime fechaCreacion;

    @Enumerated(EnumType.STRING)
    private EstadoPublicacion estado;

    public Publicacion(PublicacionCrear crear, Usuario usuario) {
        this.contenido = crear.contenido();
        this.usuario = usuario;
        this.fechaCreacion = LocalDateTime.now();
        this.estado = EstadoPublicacion.ACTIVO;
    }

    public void agregarCometario(Comentario comentario){
        this.comentarios.add(comentario);
    }

    public void actualizar(PublicacionEditar editar){
        if (editar != null) {
            this.contenido = editar.contenido();
        }
    }
}
