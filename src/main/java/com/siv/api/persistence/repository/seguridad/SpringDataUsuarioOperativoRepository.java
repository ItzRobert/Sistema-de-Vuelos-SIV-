package com.siv.api.persistence.repository.seguridad;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siv.api.persistence.entity.UsuarioOperativo;

public interface SpringDataUsuarioOperativoRepository extends JpaRepository<UsuarioOperativo, Integer> {
    Optional<UsuarioOperativo> findByUsername(String username);
}