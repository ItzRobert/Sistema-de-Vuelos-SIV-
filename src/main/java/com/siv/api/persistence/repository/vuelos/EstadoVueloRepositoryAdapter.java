package com.siv.api.persistence.repository.vuelos;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.siv.api.domain.repository.EstadoVueloRepository;

@Repository
public class EstadoVueloRepositoryAdapter implements EstadoVueloRepository {

    private final SpringDataEstadoVueloRepository jpa;

    public EstadoVueloRepositoryAdapter(SpringDataEstadoVueloRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public List<com.siv.api.domain.model.vuelos.EstadoVuelo> findAll() {
        return jpa.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public Optional<com.siv.api.domain.model.vuelos.EstadoVuelo> findById(Integer id) {
        return jpa.findById(id).map(this::toDomain);
    }

    @Override
    public com.siv.api.domain.model.vuelos.EstadoVuelo save(com.siv.api.domain.model.vuelos.EstadoVuelo estado) {
        var saved = jpa.save(toEntity(estado));
        return toDomain(saved);
    }

    private com.siv.api.domain.model.vuelos.EstadoVuelo toDomain(
            com.siv.api.persistence.entity.vuelos.EstadoVuelo e
    ) {
        return new com.siv.api.domain.model.vuelos.EstadoVuelo(
                e.getEstadoVueloId(),
                e.getNombre()
        );
    }

    private com.siv.api.persistence.entity.vuelos.EstadoVuelo toEntity(
            com.siv.api.domain.model.vuelos.EstadoVuelo d
    ) {
        var e = new com.siv.api.persistence.entity.vuelos.EstadoVuelo();
        e.setEstadoVueloId(d.getId());
        e.setNombre(d.getNombre());
        return e;
    }
}
