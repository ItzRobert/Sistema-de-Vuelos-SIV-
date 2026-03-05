package com.siv.api.domain.repository;

import java.util.List;
import java.util.Optional;

import com.siv.api.domain.model.auditoria.AuditoriaEvento;

public interface AuditoriaEventoRepository {
    List<AuditoriaEvento> findAll();
    Optional<AuditoriaEvento> findById(Long id);
    AuditoriaEvento save(AuditoriaEvento evento);
}
