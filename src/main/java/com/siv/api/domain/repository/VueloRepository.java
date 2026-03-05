package com.siv.api.domain.repository;

import java.util.List;
import java.util.Optional;

import com.siv.api.domain.model.vuelos.Vuelo;

public interface VueloRepository {
    List<Vuelo> findAll();
    Optional<Vuelo> findById(Long id);
    Vuelo save(Vuelo vuelo);
}
