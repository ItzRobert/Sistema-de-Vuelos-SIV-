package com.siv.api.persistence.repository.catalogos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siv.api.persistence.entity.catalogos.Aerolinea;

public interface SpringDataAerolineaRepository extends JpaRepository<Aerolinea, Integer> {
}