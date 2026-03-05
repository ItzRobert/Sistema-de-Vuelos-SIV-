package com.siv.api.domain.repository;

import java.util.List;
import java.util.Optional;

import com.siv.api.domain.model.notificaciones.Notificacion;

public interface NotificacionRepository {
    List<Notificacion> findAll();
    Optional<Notificacion> findById(Long id);
    List<Notificacion> findBySuscripcionId(Long suscripcionId);
    Notificacion save(Notificacion notificacion);
}
