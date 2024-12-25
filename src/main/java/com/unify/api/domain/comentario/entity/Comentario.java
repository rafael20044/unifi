package com.unify.api.domain.comentario.entity;

import com.unify.api.domain.comentario.dto.ComentarioCrear;
import com.unify.api.domain.publicacion.entity.Publicacion;
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
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publicacion_id")
    private Publicacion publicacion;

    @Column(length = 500)
    private String contenido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comentario_padre_id")
    private Comentario comentarioPadre;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "comentarioPadre")
    private List<Comentario> comentarios;

    private LocalDateTime fechaCreacion;


    public Comentario(ComentarioCrear crear, Usuario usuario, Publicacion publicacion, Comentario cometarioPadre) {
        this.usuario = usuario;
        this.publicacion = publicacion;
        this.comentarioPadre = cometarioPadre;
        this.contenido = crear.contenido();
        this.fechaCreacion = LocalDateTime.now();
    }
}
