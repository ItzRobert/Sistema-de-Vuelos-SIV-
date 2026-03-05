package com.siv.api.domain.repository;

import java.util.List;
import java.util.Optional;

import com.siv.api.domain.model.operaciones.TipoCambio;

public interface TipoCambioRepository {
    List<TipoCambio> findAll();
    Optional<TipoCambio> findById(Integer id);
    TipoCambio save(TipoCambio tipoCambio);
}
