package com.siv.api.persistence.repository.vuelos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siv.api.persistence.entity.vuelos.EstadoVuelo;

public interface SpringDataEstadoVueloRepository extends JpaRepository<EstadoVuelo, Integer> {
}
