package com.siv.api.repository.notificaciones;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.siv.api.entity.dbo.notificaciones.Suscripcion;

public interface SuscripcionRepository extends JpaRepository<Suscripcion, Long> {
    List<Suscripcion> findByVuelo_VueloId(Long vueloId);
}