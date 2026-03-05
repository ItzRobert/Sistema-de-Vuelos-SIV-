package com.siv.api.persistence.repository.notificaciones;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siv.api.persistence.entity.Suscripcion;

public interface SuscripcionRepository extends JpaRepository<Suscripcion, Long> {
    List<Suscripcion> findByVuelo_VueloId(Long vueloId);
}