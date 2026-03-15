package com.siv.api.persistence.repository.vuelos;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.siv.api.domain.repository.VueloRepository;

@Repository
public class VueloRepositoryAdapter implements VueloRepository {

    private final SpringDataVueloRepository jpa;

    public VueloRepositoryAdapter(SpringDataVueloRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public List<com.siv.api.domain.model.vuelos.Vuelo> findAll() {
        return jpa.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public Optional<com.siv.api.domain.model.vuelos.Vuelo> findById(Long id) {
        return jpa.findById(id).map(this::toDomain);
    }

    @Override
    public com.siv.api.domain.model.vuelos.Vuelo save(com.siv.api.domain.model.vuelos.Vuelo vuelo) {
        var saved = jpa.save(toEntity(vuelo));
        return toDomain(saved);
    }

    private com.siv.api.domain.model.vuelos.Vuelo toDomain(
            com.siv.api.persistence.entity.vuelos.VueloEntity e
    ) {
        Long aerolineaId = (e.getAerolinea() == null || e.getAerolinea().getAerolineaId() == null)
                ? null
                : e.getAerolinea().getAerolineaId().longValue();

        Long origenId = (e.getOrigenAeropuerto() == null || e.getOrigenAeropuerto().getAeropuertoId() == null)
                ? null
                : e.getOrigenAeropuerto().getAeropuertoId().longValue();

        Long destinoId = (e.getDestinoAeropuerto() == null || e.getDestinoAeropuerto().getAeropuertoId() == null)
                ? null
                : e.getDestinoAeropuerto().getAeropuertoId().longValue();

        Long estadoVueloId = (e.getEstadoVuelo() == null || e.getEstadoVuelo().getEstadoVueloId() == null)
                ? null
                : e.getEstadoVuelo().getEstadoVueloId().longValue();

        return new com.siv.api.domain.model.vuelos.Vuelo(
                e.getVueloId(),
                e.getNumeroVuelo(),
                aerolineaId,
                origenId,
                destinoId,
                estadoVueloId,
                e.getFuente(),
                e.getFechaVuelo(),
                e.getHoraProgramadaSalida(),
                e.getHoraProgramadaLlegada()
        );
    }

    private com.siv.api.persistence.entity.vuelos.VueloEntity toEntity(
            com.siv.api.domain.model.vuelos.Vuelo d
    ) {
        var e = new com.siv.api.persistence.entity.vuelos.VueloEntity();

        e.setVueloId(d.getId());
        e.setNumeroVuelo(d.getNumero());

        var aerolinea = new com.siv.api.persistence.entity.catalogos.AerolineaEntity();
        aerolinea.setAerolineaId(d.getAerolineaId() == null ? null : d.getAerolineaId().intValue());
        e.setAerolinea(aerolinea);

        var origen = new com.siv.api.persistence.entity.vuelos.AeropuertoEntity();
        origen.setAeropuertoId(d.getOrigenAeropuertoId() == null ? null : d.getOrigenAeropuertoId().intValue());
        e.setOrigenAeropuerto(origen);

        var destino = new com.siv.api.persistence.entity.vuelos.AeropuertoEntity();
        destino.setAeropuertoId(d.getDestinoAeropuertoId() == null ? null : d.getDestinoAeropuertoId().intValue());
        e.setDestinoAeropuerto(destino);

        var estado = new com.siv.api.persistence.entity.vuelos.EstadoVueloEntity();
        estado.setEstadoVueloId(d.getEstadoVueloId() == null ? null : d.getEstadoVueloId().intValue());
        e.setEstadoVuelo(estado);

        e.setFechaVuelo(d.getFecha());
        e.setHoraProgramadaSalida(d.getHoraSalida());
        e.setHoraProgramadaLlegada(d.getHoraLlegada());
        e.setFuente(d.getFuente());
        e.setUltimaActualizacion(java.time.LocalDateTime.now());
        return e;
        
    }
}