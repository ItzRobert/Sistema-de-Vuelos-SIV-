package com.siv.api.persistence.repository.vuelos;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.siv.api.domain.repository.AeropuertoRepository;

@Repository
public class AeropuertoRepositoryAdapter implements AeropuertoRepository {

    private final SpringDataAeropuertoRepository jpa;

    public AeropuertoRepositoryAdapter(SpringDataAeropuertoRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public List<com.siv.api.domain.model.vuelos.Aeropuerto> findAll() {
        return jpa.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public Optional<com.siv.api.domain.model.vuelos.Aeropuerto> findById(Integer id) {
        return jpa.findById(id).map(this::toDomain);
    }

    @Override
    public com.siv.api.domain.model.vuelos.Aeropuerto save(com.siv.api.domain.model.vuelos.Aeropuerto aeropuerto) {
        var saved = jpa.save(toEntity(aeropuerto));
        return toDomain(saved);
    }

    // --------- MAPPERS ---------

    private com.siv.api.domain.model.vuelos.Aeropuerto toDomain(
            com.siv.api.persistence.entity.vuelos.Aeropuerto e
    ) {
        return new com.siv.api.domain.model.vuelos.Aeropuerto(
                e.getAeropuertoId() == null ? null : e.getAeropuertoId().longValue(),
                e.getCodigoIata(),
                e.getNombre(),
                e.getCiudad(),
                e.getPais(),
                e.getActivo() != null && e.getActivo(),
                e.getFechaCreacion()
        );
    }

    private com.siv.api.persistence.entity.vuelos.Aeropuerto toEntity(
            com.siv.api.domain.model.vuelos.Aeropuerto d
    ) {
        var e = new com.siv.api.persistence.entity.vuelos.Aeropuerto();

        if (d.getId() != null) {
            e.setAeropuertoId(d.getId().intValue());
        }

        e.setCodigoIata(d.getCodigoIATA());
        e.setNombre(d.getNombre());
        e.setCiudad(d.getCiudad());
        e.setPais(d.getPais());
        e.setActivo(d.isActivo());

        // si tu domain no maneja fechaCreacion, elimina esta línea.
        e.setFechaCreacion(d.getFechaCreacion());

        return e;
    }
}