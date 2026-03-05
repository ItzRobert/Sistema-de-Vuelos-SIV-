package com.siv.api.domain.repository;

import java.util.List;
import java.util.Optional;

import com.siv.api.domain.model.vuelos.Aeropuerto;

public interface AeropuertoRepository {

    List<Aeropuerto> findAll();

    Optional<Aeropuerto> findById(Integer id);

    Aeropuerto save(Aeropuerto aeropuerto);
}
