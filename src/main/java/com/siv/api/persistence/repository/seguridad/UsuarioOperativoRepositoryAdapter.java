package com.siv.api.persistence.repository.seguridad;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.siv.api.domain.repository.UsuarioOperativoRepository;

@Repository
public class UsuarioOperativoRepositoryAdapter implements UsuarioOperativoRepository {

    private final SpringDataUsuarioOperativoRepository jpa;

    public UsuarioOperativoRepositoryAdapter(SpringDataUsuarioOperativoRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public List<com.siv.api.domain.model.seguridad.UsuarioOperativo> findAll() {
        return jpa.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public Optional<com.siv.api.domain.model.seguridad.UsuarioOperativo> findById(Integer id) {
        return jpa.findById(id).map(this::toDomain);
    }

    @Override
    public Optional<com.siv.api.domain.model.seguridad.UsuarioOperativo> findByUsername(String username) {
        return jpa.findByUsername(username).map(this::toDomain);
    }

    @Override
    public com.siv.api.domain.model.seguridad.UsuarioOperativo save(
            com.siv.api.domain.model.seguridad.UsuarioOperativo usuario
    ) {
        var saved = jpa.save(toEntity(usuario));
        return toDomain(saved);
    }

    // ------------ MAPPERS ------------

    private com.siv.api.domain.model.seguridad.UsuarioOperativo toDomain(
            com.siv.api.persistence.entity.UsuarioOperativo e
    ) {
        return new com.siv.api.domain.model.seguridad.UsuarioOperativo(
                e.getUsuarioOperativoId(),
                e.getUsername(),
                e.getNombreCompleto(),
                e.getActivo(),
                e.getFechaCreacion()
        );
    }

    private com.siv.api.persistence.entity.UsuarioOperativo toEntity(
            com.siv.api.domain.model.seguridad.UsuarioOperativo d
    ) {
        var e = new com.siv.api.persistence.entity.UsuarioOperativo();
        e.setUsuarioOperativoId(d.getId());
        e.setUsername(d.getUsername());
        e.setNombreCompleto(d.getNombre());
        e.setActivo(d.getActivo());
        e.setFechaCreacion(d.getFechaCreacion());
        return e;
    }
}
