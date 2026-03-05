package com.siv.api.domain.repository;

import java.util.List;
import java.util.Optional;

import com.siv.api.domain.model.notificaciones.Suscripcion;

public interface SuscripcionRepository {
    List<Suscripcion> findAll();
    Optional<Suscripcion> findById(Long id);
    List<Suscripcion> findByVueloId(Long vueloId);
    Suscripcion save(Suscripcion suscripcion);
}
