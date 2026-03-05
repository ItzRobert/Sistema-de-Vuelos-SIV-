package com.siv.api.domain.repository;

import java.util.List;
import java.util.Optional;

import com.siv.api.domain.model.operaciones.CambioOperativo;

public interface CambioOperativoRepository {
    List<CambioOperativo> findAll();
    Optional<CambioOperativo> findById(Long id);
    CambioOperativo save(CambioOperativo cambio);

  
    List<CambioOperativo> findByVueloId(Long vueloId);
}
