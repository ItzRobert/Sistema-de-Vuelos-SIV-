package com.siv.api.persistence.repository.vuelos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siv.api.persistence.entity.vuelos.EstadoVueloEntity;

public interface SpringDataEstadoVueloRepository extends JpaRepository<EstadoVueloEntity, Integer> {
}
