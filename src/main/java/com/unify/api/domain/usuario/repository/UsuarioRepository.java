package com.unify.api.domain.usuario.repository;

import com.unify.api.domain.usuario.entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("""
            SELECT u FROM Usuario u WHERE u.estado = com.unify.api.domain.enums.Estado.ACTIVO
            """)
    Page<Usuario> buscarTodosActivos(Pageable pageable);

    Optional<Usuario> findByCorreo(String correo);
}
