package com.siv.api.persistence.repository.notificaciones;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siv.api.persistence.entity.Notificacion;

public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {
    List<Notificacion> findBySuscripcion_SuscripcionId(Long suscripcionId);
}