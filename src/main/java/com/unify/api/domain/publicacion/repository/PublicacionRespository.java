package com.unify.api.domain.publicacion.repository;

import com.unify.api.domain.publicacion.entity.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicacionRespository extends JpaRepository<Publicacion, Long> {
}
