package com.siv.api.persistence.repository.operaciones;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siv.api.persistence.entity.vuelos.VueloEntity;

public interface VueloRepository extends JpaRepository<VueloEntity, Long> { }