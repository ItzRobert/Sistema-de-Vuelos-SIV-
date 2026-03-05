package com.siv.api.domain.repository;

import java.util.List;
import java.util.Optional;

import com.siv.api.domain.model.operaciones.CausaOperativa;

public interface CausaOperativaRepository {
    List<CausaOperativa> findAll();
    Optional<CausaOperativa> findById(Integer id);
    CausaOperativa save(CausaOperativa causa);
}
