package com.siv.api.repository.notificaciones;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.siv.api.entity.dbo.notificaciones.Notificacion;

public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {
    List<Notificacion> findBySuscripcion_SuscripcionId(Long suscripcionId);
}