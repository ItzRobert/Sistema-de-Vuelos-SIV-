package com.siv.api.domain.repository;

import java.util.List;
import java.util.Optional;

import com.siv.api.domain.model.catalogos.Aerolinea;

public interface AerolineaRepository {
    List<Aerolinea> findAll();
    Optional<Aerolinea> findById(Integer id);
    Aerolinea save(Aerolinea aerolinea);
}