package com.siv.api.domain.repository;

import java.util.List;
import java.util.Optional;

import com.siv.api.domain.model.seguridad.UsuarioOperativo;

public interface UsuarioOperativoRepository {
    List<UsuarioOperativo> findAll();
    Optional<UsuarioOperativo> findById(Integer id);
    UsuarioOperativo save(UsuarioOperativo usuario);

    Optional<UsuarioOperativo> findByUsername(String username);
}