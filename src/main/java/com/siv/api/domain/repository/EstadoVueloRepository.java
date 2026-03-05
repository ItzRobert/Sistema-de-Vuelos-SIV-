package com.siv.api.domain.repository;

import java.util.List;
import java.util.Optional;

import com.siv.api.domain.model.vuelos.EstadoVuelo;

public interface EstadoVueloRepository {
    List<EstadoVuelo> findAll();
    Optional<EstadoVuelo> findById(Integer id);
    EstadoVuelo save(EstadoVuelo estado);
}